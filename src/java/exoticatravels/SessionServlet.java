package exoticatravels;

import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"}, asyncSupported=true)
public class SessionServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            AsyncContext aCtx = request.startAsync(request, response);
            ScheduledThreadPoolExecutor executor;
            executor = new ScheduledThreadPoolExecutor(10);
            System.out.println("within session servlet");
            executor.execute(new Asynchandler(aCtx));
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
