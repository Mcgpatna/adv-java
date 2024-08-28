<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/UserNameTLD.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Page</title>
    </head>
    <body>
        <jsp:include page="Template1.jsp"></jsp:include>
        <td valign='top' rowspan='200' colspan='80'>
        <!--<div align="right"><ct:UserNameTagHandler/></div> -->
         <% String role=session.getAttribute("role").toString();%>
        <font color='darkblue' size='+2'>Welcome to the Exotica Travels Website!!</font>
  
        <h1>Page under construction</h1>
        <%if (role.equals("customer")) {%>
        <div align="left"><a href="WelcomeCustomerPage.jsp"> Home Page </a></div> 
        <%} else {%>
            
            <br><a href="WelcomeAdminPage.jsp" ><font style="font-size:18px;">Home Page</font></a>
            <%} %>
    </body>
</html>
