/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exoticatravels;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author rmn
 */
public class HomePageBean extends org.apache.struts.action.ActionForm {
    
    private String r1, r2;
    
    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }
    
    public HomePageBean() {
        super();
        // TODO Auto-generated constructor stub
    }

//    /**
//     * This is the action called from the Struts framework.
//     *
//     * @param mapping The ActionMapping used to select this instance.
//     * @param request The HTTP Request we are processing.
//     * @return
//     */
//    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
//        return errors;
//    }
}
