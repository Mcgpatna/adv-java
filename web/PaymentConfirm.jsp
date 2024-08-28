<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>    
              <title>Payment Page</title>                
              </head>    
              <body>    
                  <jsp:include page="Template1.jsp"></jsp:include>
                  <td valign="top" rowspan="200" colspan="80">
                  <center>
                      <table>
                          <caption style="color:blue; font-size:20px";><b>Payment Process Page</b></caption>
                          <form action="PaymentProcess" method="post">
                             
                              <tr>
                                  <td><b>User id</b></td>
                                  <td><b><% String emailid=session.getAttribute("emailid").toString();out.println(emailid); %></b></td>
                                         <% session.setAttribute("emailid",emailid ); %>
                              </tr>
                              <tr>
                                  <td><b>Booking Id</b></td>
                                  <td><b><% String cartid=session.getAttribute("cartid").toString(); out.println(cartid); %></b></td>
                                         <% session.setAttribute("cartid",cartid ); %>
                              
                              </tr>
                              <tr>
                                  <td><b>Amount </b></td>
                                  <td><b><% String price=session.getAttribute("price").toString(); out.println(price); %></b></td>
                                          <% session.setAttribute("price",price ); %>
                              </tr>
                              <tr>
                                  <td><b>Enter payment details</b></td>
                                  <td><textarea name="details" rows="3" cols="30"></textarea></td>
                              </tr>
                              <tr>
                                  <td><input type="submit"></td><td><input type="reset"></td>
                              </tr>
                          </form>
                      </table>
                      
                  </center>
                 <!-- <br><a href="WelcomeAdminPage.jsp" >Admin Page</a> -->
</body>
</html>
