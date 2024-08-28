/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoticatravels;

import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author rmn
 */
public class DBListTagHandler extends SimpleTagSupport {

    private String tablename;
    private String colname;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExoticaTravelsPU2");
            EntityManager em = emf.createEntityManager();
            EntityTransaction userTransaction = em.getTransaction();
            userTransaction.begin();
            
            
            
            

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
            Query query1 = em.createNativeQuery("SELECT " + colname +" FROM " + tablename);
            List result = query1.getResultList(); //check
            Iterator it = result.iterator();
           // out.println("<select name='selvar'>");
             out.println("<select name='"+tablename+"'>");
            while(it.hasNext())
            {
                String name = it.next().toString();
                out.println("<option value='"+name+"'>"+name+"</option>");
            }
            out.println("</select>");
            userTransaction.commit();
          em.close();
        } 
        catch (java.io.IOException ex) {
            throw new JspException("Error in DBListTagHandler tag", ex);
        }
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public void setColname(String colname) {
        this.colname = colname;
    }
    
}
