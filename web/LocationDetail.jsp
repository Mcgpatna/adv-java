<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>    
              <title>Domestic Locations</title>                
              </head>    
              <body>    
                  <jsp:include page="Template1.jsp"></jsp:include>
                  <td valign="top" rowspan="200" colspan="80">
                  <center>
                      
                  <h3>Domestic Location Maintenance Page</h3>
                          
                 <a href="DLocationAdd.jsp"><font color='darkblue' size='+3'>Add Locations</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <a href="DLocationMod.jsp"><font color='darkblue' size='+3'>Modify Locations</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="DLocationView"><font color='darkblue' size='+3'>View Locations</font></a>
                  </center>                         
           <br><a href="WelcomeAdminPage.jsp" >Admin Page</a>               
                     
    </body>
</html>
