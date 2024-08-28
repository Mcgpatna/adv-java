
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
       <!-- <div align="right"><ct:UserNameTagHandler/></div> -->
        <font color='darkblue' size='+2'>Welcome to the Exotica Travels Website!!</font>
        <table>
            <table>
            <tr><td><font color='darkblue' size='+1'><a href='<c:url value="DomesticFlightDetail.jsp"/>'>Domestic Flights</a></td></tr>
            <tr><td><font color='darkblue' size='+1'><a href='<c:url value="ConstructionPage.jsp"/>'>International Flights</a></td></tr>
            <tr><td><font color='darkblue' size='+1'><a href='<c:url value="HotelDetail.jsp"/>'>Hotels</a></td></tr>
            <tr><td><font color='darkblue' size='+1'><a href='<c:url value="LocationDetail.jsp"/>'>Locations</a></td></tr>
            <tr><td><font color='darkblue' size='+1'><a href='<c:url value="CustomerView"/>'>View Customer Details</a></td></tr>
            <tr><td><font color='darkblue' size='+1'><a href='<c:url value="DomesticCustTourView"/>'>View Booking Details</a></td></tr>
            <tr><td><font color='darkblue' size='+1'><a href='<c:url value="CancelBooking"/>'>Cancel Booking </a></td></tr>
             
        </table>
        <% String role=session.getAttribute("role").toString();
               session.setAttribute("role", role); %>
        <br/><br/><br/><br/><br/><br/>
      <div align="left"><ct:UserNameTagHandler/></div>   
    </body>
</html>
