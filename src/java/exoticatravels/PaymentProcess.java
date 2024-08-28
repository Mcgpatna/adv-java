/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoticatravels;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author admin
 */
public class PaymentProcess extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(false);
            System.out.println("session " +session);
            int cartid=Integer.parseInt(session.getAttribute("cartid").toString());
            String email=session.getAttribute("emailid").toString();
            double packagePrice = Double.parseDouble(session.getAttribute("price").toString());
            Date dt=new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dt1=formatter.format(dt);
            String details=request.getParameter("details");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExoticaTravelsPU2");
            EntityManager em = emf.createEntityManager();
            EntityTransaction userTransaction = em.getTransaction();
            userTransaction.begin();
            
            
            Query query2 = em.createNativeQuery("INSERT INTO payment VALUES('" + email +"',"+ cartid + ","+ packagePrice +",'" + dt1 + "','" +details +"')");
            query2.executeUpdate();
            
            query2 = em.createNativeQuery("delete from cart_temp");
             query2.executeUpdate();
            userTransaction.commit();
            em.close();
          System.out.println("emailid:"+email+" cartid:"+cartid+" date :"+dt1+" amount :"+packagePrice+"\n details :"+details);
           String dest = session.getAttribute("selDestination").toString();
            //System.out.println("//////////selDestination: " + dest);
            String hotel = session.getAttribute("selHotel").toString();
            //System.out.println("//////////selHotel: " + hotel);
            String airline = session.getAttribute("selAirline").toString();
            //System.out.println("//////////selAirline: " + airline);
            int days = Integer.parseInt(session.getAttribute("numDays").toString());
            //System.out.println("//////////numDays: " + days + " price: " + price);
           // double packagePrice = Double.parseDouble(price);
          response.sendRedirect("CartConfirm.jsp");
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
