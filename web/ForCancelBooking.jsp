
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
                <% session = request.getSession(false);
             String userid = session.getAttribute("User").toString();
            
                    %>
                <form method="post" action="CancelBookingConfirm">
            <table cellspacing='10' align='center'border='2' bordercolor='black'>
               <caption style="color:blue; font-size:20px";><b>View Domestic Flight Details</b></caption>
                     <tr>
                          <th style="color:blue; font-size:20px">Booking Code</th>
                          <th style="color:blue; font-size:20px">User id</th>
                          <th style="color:blue; font-size:20px">Click to Cancel</th>
                          
                     </tr>
                          
            <c:forEach var="row" items="${BookingData}">
            <tr>
                <td style="color:darkblue;font-size:18px"><c:out value="${row[0]}"/></td>
                <td style="color:darkblue;font-size:18px"><c:out value="${row[1]}"/></td>
                <td style="color:darkblue;font-size:18px"><input type="submit" value="${row[0]}" name="btn"/></td>
                <input type="hidden" value="${row[0]}" name="code" />
            </tr>
            </c:forEach>
            </table>
                    <% request.setAttribute("User",userid); %>
        </form>
       <br><a href="WelcomeAdminPage.jsp" ><font style="font-size:18px;">Home Page</font></a>
            
    </body>
</html>

           