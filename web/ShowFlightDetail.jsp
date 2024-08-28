
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="Template1.jsp"></jsp:include>
           <td valign="top" rowspan="200" colspan="80">
            <center>
                <% String role=session.getAttribute("role").toString();%>
            <table cellspacing='10' align='center'border='2' bordercolor='black'>
               <caption style="color:blue; font-size:20px";><b>View Domestic Flight Details</b></caption>
                     <tr>
                <%if (role.equals("administrator")) {%>
                          <th style="color:blue; font-size:20px">Flight Code</th> 
                <% }%>
                          <th style="color:blue; font-size:20px">Flight Name</th>
                          <th style="color:blue; font-size:20px">Price</th>
                      </tr>
            <c:forEach var="row" items="${FlightData}">
            <tr>
                <%if (role.equals("administrator")){%>
                <td style="color:darkblue;font-size:18px"><c:out value="${row[0]}"/></td>
                <%}%>
                <td style="color:darkblue;font-size:18px"><c:out value="${row[1]}"/></td>
                <td style="color:darkblue;font-size:18px"><c:out value="${row[2]}"/></td>
            </tr>
            </c:forEach>
            </table>
            <% 
               
                if (role.equals("administrator"))
                {
            %>
            <br><a href="DomesticFlightDetail.jsp" ><font style="font-size:18px;">Domestic Flight Page</font></a>
            <%} else {%>
            
            <br><a href="WelcomeCustomerPage.jsp" ><font style="font-size:18px;">Home Page</font></a>
            <%} %>
    </body>
</html>
