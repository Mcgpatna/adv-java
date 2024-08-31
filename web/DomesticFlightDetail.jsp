<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>    
              <title>Domestic Flight Page</title>                
              </head>    
              <body>    
                  <jsp:include page="Template1.jsp"></jsp:include>
                  <td valign="top" rowspan="200" colspan="80">
                  <center>
                      
                  <h3>Domestic Flight Maintenance Page</h3>
                          
                 <a href="DomesticFlighAdd.jsp"><font color='darkblue' size='+3'>Add Flight</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <a href="DFlightView" ><font color='darkblue' size='+3'>Modify Flight</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="DomesticFlightView"><font color='darkblue' size='+3'>View Flight</font></a>
                  </center>                         
           <br><a href="WelcomeAdminPage.jsp" >Admin Page</a>               
                     
    </body>
</html>
