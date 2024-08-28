/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoticatravels;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import javax.persistence.Persistence;

/**
 *
 * @author rmn
 */
public class RegistrationAction extends org.apache.struts.action.Action {
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        RegistrationBean rBean = (RegistrationBean)form;
        //String uName = rBean.getUsername();
         String email = rBean.getEmailid();
        //String uId = rBean.getUserid();
        String uName = rBean.getUsername();
        String pwd = rBean.getPassword();
        String rpwd = rBean.getReenterpassword();
        String address = rBean.getAddress();
        String  state = rBean.getState();
        String country = rBean.getCountry();

        String msg;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExoticaTravelsPU2");//("ExoticaTravelsPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction userTransaction = em.getTransaction();
        userTransaction.begin();
        
       // Query query = em.createNativeQuery("SELECT UserName FROM Registration WHERE UserID = '" + uId + "'");
        Query query = em.createNativeQuery("SELECT EmailId FROM Registration WHERE EmailId = '" + email + "'");
        List idList = query.getResultList();
        
        if(idList.size() == 1)
        {
            //msg = "Specified User ID already exists";
            msg = "Specified Email ID already exists";
            request.setAttribute("errMsg", msg);
            return mapping.findForward(ERROR);
        }
        else if(!pwd.equals(rpwd) || pwd=="")
        {
            msg = "Password not entered or password enterd does not match";
            request.setAttribute("errMsg", msg);
            return mapping.findForward(ERROR);
        }
        else
        {
            RegistrationEntity re = new RegistrationEntity();
            re.setUsername(uName);; //re.setUsername(uName);
            re.setEmailid(email); //re.setUserid(uId);
            re.setPassword(pwd);
            re.setAddress(address);
            re.setCountry(country);
            re.setState(state);
            re.setGroupname("customer");
            em.persist(re);
            userTransaction.commit();
            em.close();
            emf.close();
            msg = uName;
            request.setAttribute("NewUser", msg);
            return mapping.findForward(SUCCESS);
        }
        
    }
}
