package exoticatravels;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(filterName = "IPFilter", urlPatterns = {"/GetLogDetails"}, initParams = {@WebInitParam(name="validip", value="0:0:0:0:0:0:0:1")}) //change to your own IP
public class IPFilter implements Filter {
    
    private static final boolean debug = true;
    private String validip;
    private FilterConfig filterConfig = null;
    
    public IPFilter() {
        System.out.println("inside IPFilter ...");
        
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("IPFilter:DoBeforeProcessing");
        }
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("IPFilter:DoAfterProcessing");
        }
    }
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        if (debug) {
            log("IPFilter:doFilter()");
        }
        
        doBeforeProcessing(request, response);
        System.out.println("////////////////////////////////request.getRemoteHost():"+request.getRemoteHost());
        System.out.println("////////////////////////////////request.getRemoteAddr():"+request.getRemoteAddr());
        
        Throwable problem = null;
        try {
            System.out.println("/*/*/*/**/***/*/*/*/*/******/*/*/*/*/**///*/**/*/request.getRemoteHost():"+request.getRemoteHost());
            System.out.println("/*/*/**/*/**/****/***/*/*/*/*/*/*/*/*/*/***/*/*/*request.getRemoteAddr():"+request.getRemoteAddr());
            if(request.getRemoteAddr().equals(this.validip))
            {
                RequestDispatcher rd = request.getRequestDispatcher("GetLogDetails.jsp");
                rd.forward(request, response);
            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
                rd.forward(request, response);
            }
            chain.doFilter(request, response);
        } catch (Throwable t) {
            problem = t;
            t.printStackTrace();
        }
        
        doAfterProcessing(request, response);
        
        if (problem != null) {
            if (problem instanceof ServletException) {
                throw (ServletException) problem;
            }
            if (problem instanceof IOException) {
                throw (IOException) problem;
            }
            sendProcessingError(problem, response);
        }
    }
    
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
    
    public void destroy() {
        throw new UnsupportedOperationException("Not Supported Yet");
    }
    
    public void init(final FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        this.validip = filterConfig.getInitParameter("validip");
        if (filterConfig != null) {
            if (debug) {                
                log("IPFilter:Initializing filter");
            }
        }
    }

    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("IPFilter()");
        }
        StringBuffer sb = new StringBuffer("IPFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
