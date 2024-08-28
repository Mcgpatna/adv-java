<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>    
              <title>Domestic Location Maintenance Page</title>                
              </head>    
              <body>    
                  <jsp:include page="Template1.jsp"></jsp:include>
                  <td valign="top" rowspan="200" colspan="80">
                  <center>
                      <table>
                          <caption style="color:blue; font-size:20px";><b>Adding Domestic Locations</b></caption>
                          <form action="DLocationAdd" method="post">
                              
                              <tr>
                                  <td><b>Enter Location Name</b></td>
                                  <td><input type="text" name="lnm" placeholder="Location Name" required/></td>
                              </tr>
                              <tr>
                                  <td><b>Enter Price</b></td>
                                  <td><input type="text" name="price" placeholder="Price" required/></td>
                              </tr>
                              <tr>
                                  <td><input type="submit"></td><td><input type="reset"></td>
                              </tr>
                          </form>
                      </table>
                      
                  </center>
                  <br><a href="WelcomeAdminPage.jsp" >Admin Page</a>
</body>
</html>
