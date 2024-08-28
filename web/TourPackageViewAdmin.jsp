<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/UserNameTLD.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <jsp:include page="Template1.jsp"></jsp:include>
        <td valign='top' rowspan='200' colspan='80'>
        
        
        <table cellspacing='10' align=left' border='2' bordercolor='black'>
            <caption style="color:blue; font-size:20px;"><b>View All Booking Details</b></caption>
               
                     <tr>
                          <th style="color:blue; font-size:15px">Booking Id</th> 
                          <th style="color:blue; font-size:15px">User Id</th> 
                          <th style="color:blue; font-size:15px">Destination</th> 
                          <th style="color:blue; font-size:15px">Hotel</th>
                          <th style="color:blue; font-size:15px">Airline</th>
                          <th style="color:blue; font-size:15px">Tour Cost</th>
                          <th style="color:blue; font-size:15px">Start Date</th>
                          <th style="color:blue; font-size:15px">End Date</th>
                          <th style="color:blue; font-size:15px">No of Days</th>
                          
                           <th style="color:blue; font-size:15px">Status</th> 
                         
                      </tr>
            <c:forEach var="row" items="${CartData}">
            <tr>
                <td style="color:darkblue;font-size:12px"><c:out value="${row[0]}"/></td>
                <td style="color:darkblue;font-size:12px"><c:out value="${row[1]}"/></td>
                <td style="color:darkblue;font-size:12px"><c:out value="${row[2]}"/></td>
                <td style="color:darkblue;font-size:12px"><c:out value="${row[3]}"/></td>
                
                <td style="color:darkblue;font-size:12px"><c:out value="${row[5]}"/></td>
                <td style="color:darkblue;font-size:12px"><c:out value="${row[6]}"/></td>
                <td style="color:darkblue;font-size:12px"><c:out value="${row[7]}"/></td>
                <td style="color:darkblue;font-size:12px"><c:out value="${row[8]}"/></td>
                <td style="color:darkblue;font-size:12px"><c:out value="${row[4]}"/></td>
                
                <td style="color:darkblue;font-size:12px"><c:out value="${row[9]}"/></td>
            </tr>
            </c:forEach>
            </table>
        <br/><br/><a href="WelcomeAdminPage.jsp" ><font style="font-size:18px;">Home Page</font></a>
              <br/><br/><br/><br/><br/><br/>
      <!--<div align="left"><ct:UserNameTagHandler/></div>  -->
        
    </body>
</html>
