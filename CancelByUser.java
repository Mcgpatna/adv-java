
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


public class CancelByUser extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       HttpSession session = request.getSession(false);
             String userid = session.getAttribute("User").toString();
             System.out.println("User : "+userid);
        RequestDispatcher dispatch=getServletContext().getRequestDispatcher("/WelcomeCustomerPage.jsp");
             String sdt=request.getParameter("sdt");
            int bookingId=Integer.parseInt(request.getParameter("bid"));
             String reason=request.getParameter("creason");
        try (PrintWriter out = response.getWriter()) {
           session.setAttribute("User", userid);
           EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExoticaTravelsPU2");
            EntityManager em = emf.createEntityManager();
            EntityTransaction userTransaction = em.getTransaction();
            userTransaction.begin();
            
            Query query1 = em.createNativeQuery("SELECT a.cartid,a.userid, a.startdate FROM cart a join cancelrequest b on a.cartid=b.cartid where a.cartid != b.cartid and cancel_tour is null and a.startdate>getdate() and userid='"+userid+"' and a.cartid="+bookingId);
            List result = query1.getResultList();
            System.out.println("result = "+result.size());
            if(result.size()>0)
            {
                query1 = em.createNativeQuery("INSERT INTO CancelRequest(cartid,startdate,emailid,cancel_reason) VALUES("+bookingId+",'"+sdt+"','"+userid+"','"+reason+"')");
                int j=query1.executeUpdate();
                userTransaction.commit();
                em.close();
                out.println("<h3 style='color:blue;'> Please check the Cancel status in Website only</h3>");
            }
            else
                out.println("<h3 style='color:blue;'> Please provide the valid details </h3>");
           
            
            dispatch.include(request, response);
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
