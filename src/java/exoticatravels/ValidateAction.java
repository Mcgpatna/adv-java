/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoticatravels;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.persistence.EntityManager;
import javax.persistence.*;
import javax.persistence.Persistence;
import java.util.List;


public class ValidateAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String WelcomeAdmin = "admin";
    private static final String WelcomeCustomer = "customer";
    private static final String Error = "error";

    private boolean validateUser(String uID, String Pwd, String group)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExoticaTravelsPU2");
        EntityManager em = emf.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();
        userTransaction.begin();
        System.out.println("uid: " + uID + " pwd: " + Pwd + "group: " + group);
//        Query queryCredentials = em.createNativeQuery("SELECT UserID FROM Registration where UserID='" + uID + "' and password='" + Pwd + "' AND Groupname='" + group + "'");
        Query queryCredentials = em.createNativeQuery("SELECT EmailId FROM Registration where EmailId='" + uID + "' and password='" + Pwd + "' AND Groupname='" + group + "'");
        
        List result = queryCredentials.getResultList();
        userTransaction.commit();
        em.close();
        System.out.println("******************Customer Validate Action  result= " + result);
        if(result.size()<1)
            return false;
        else if(result.size()==1)
            return true;
        else
            return false;
        
        
    }
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LoginBean lb = (LoginBean) form;
        String userid = lb.getEmailid();
        String password = lb.getPassword();
        String role = lb.getR1();
        System.out.println("****************** Validate Action  "+role+"  "+userid+"   "+password);
        if(validateUser(userid, password, role) && role.equals("administrator"))
        {
            //System.out.println("******************Inside ValidateAction.java. While Loggig in as admin");
            HttpSession session = request.getSession();
            //System.out.println("******************Line 1");
            
            session.setAttribute("User", userid);
            session.setAttribute("role",role);
            //System.out.println("******************Line 1");
            return mapping.findForward(WelcomeAdmin);
        }
        else if(validateUser(userid, password, role) && role.equals("customer"))
        {
            HttpSession session = request.getSession();
            session.setAttribute("User", userid);
            session.setAttribute("role",role);
            System.out.println("******************Customer Validate Action ");
            return mapping.findForward(WelcomeCustomer);
        }
        else
        {
            System.out.println("******************Else part  Validate Action ");
            return mapping.findForward(Error);
        }
    }
}
