/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoticatravels;

import java.io.IOException;
import java.io.PrintWriter;
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
public class DomesticCustTourView extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd=request.getRequestDispatcher("TourPackageViewCust.jsp");
        RequestDispatcher rdA=request.getRequestDispatcher("TourPackageViewAdmin.jsp");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
             String userid = session.getAttribute("User").toString();
             if(session == null){
                session.invalidate();
                
                response.sendRedirect("HomePage.jsp");
            }
             String role=session.getAttribute("role").toString();
             //String id="user1@gmail.com" ;//request.getParameter("id");
          //String code,name; double price;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExoticaTravelsPU2");
            EntityManager em = emf.createEntityManager();
            EntityTransaction userTransaction = em.getTransaction();
            userTransaction.begin();
            
          
           Query q;List <Object[]>result=null;
           if(role.equals("customer"))
           {
            q = em.createNativeQuery("SELECT * FROM Cart a WHERE cancel_tour is null and a.userid = ?");
            q.setParameter(1, userid);
            //Object[] cart = (Object[]) q.getSingleResult();
             result= q.getResultList(); 
            request.setAttribute("CartData", result);
            session.setAttribute("User", userid);         
                rd.forward(request, response);
           }
            else
           {
               q = em.createNativeQuery("SELECT * FROM Cart where cancel_tour is null");
               result= q.getResultList(); 
                request.setAttribute("CartData", result);
                session.setAttribute("User", userid);
                rdA.forward(request, response);
           }
            for(Object[] a:result)
            {
                System.out.println("Code :"+a[0]+" Name :"+a[1] +" price :"+a[2]);
            }
            
            userTransaction.commit();
          em.close();
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
