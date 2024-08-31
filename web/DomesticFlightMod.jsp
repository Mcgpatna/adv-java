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
         <% session = request.getSession(false);
             String userid = session.getAttribute("User").toString();
            
         %>
        <table>
           <caption style="color:blue; font-size:20px";><b>Modifying Domestic Flight Details</b></caption>
           <form action="DomesticFlightMod" method="post">
            <tr>
                <th style="color:blue; font-size:20px">Airline Code</th>
                <th style="color:blue; font-size:20px">Airline Name</th>
                <th style="color:blue; font-size:20px">Price</th>
                <th style="color:blue; font-size:20px">Click to Modify</th>
            </tr>
            <c:forEach var="row" items="${FlightData}">
            <tr>
                <td style="color:darkblue;font-size:18px"><c:out value="${row[0]}"/></td>
                <td style="color:darkblue;font-size:18px"><c:out value="${row[1]}"/></td>
                <td style="color:darkblue;font-size:18px"><input type="text" value="${row[2]}" name="price${row[0]}"/></td>
                <td style="color:darkblue;font-size:18px"><input type="submit" value="${row[0]}" name="btn"/></td>
               
            </tr>
            </c:forEach>
            
                    <% request.setAttribute("User",userid); %>
        </form>
        
        </table>
        <br><a href="WelcomeAdminPage.jsp" >Admin Page</a>               
           