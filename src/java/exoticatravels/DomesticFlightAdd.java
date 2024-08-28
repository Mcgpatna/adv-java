/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoticatravels;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class DomesticFlightAdd extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatch=getServletContext().getRequestDispatcher("/DomesticFlightDetail.jsp");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
             String userid = session.getAttribute("User").toString();
          String code,name; double price;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExoticaTravelsPU2");
            EntityManager em = emf.createEntityManager();
            EntityTransaction userTransaction = em.getTransaction();
            userTransaction.begin();
            
            Query query1 = em.createNativeQuery("SELECT * FROM AIRLINES");
            List result = query1.getResultList(); //check
            
            int i = result.size();
        System.out.println("no of records ="+i +" userid="+userid);
        session.setAttribute("User", userid);
        if(i==0)
            code="A001";
        else
        {i++;
            if(i>1 && i<10)
                code="A00"+i;
            else if(i>9 && i<100)
                code="A0"+i;
            else
                code="A"+i;
        }
        
        name=request.getParameter("fnm");
        price=Double.parseDouble(request.getParameter("price"));
        System.out.println(" code ="+code +" name ="+name+ " price ="+price);
        Query query2 = em.createNativeQuery("INSERT INTO airlines VALUES('" + code + "','" + name + "'," + price + ")");
        int j=query2.executeUpdate();
        if (j==1)
        {
            out.println("Data added Successfully ..");
            dispatch.include(request, response);
        }
        userTransaction.commit();
          em.close();
        }
        catch(Exception e)
        {
            System.out.println("Error in add Flight "+e);
        } 
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
