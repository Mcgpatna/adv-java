<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="ct" uri="/WEB-INF/tlds/UserNameTLD.tld" %>
<%@taglib prefix="db" uri="/WEB-INF/tlds/DBListTLD.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TourPackage Page</title>
        <link href="CSS/cssfile1.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="Template1.jsp"></jsp:include>
        <td valign='top' rowspan="200" colspan="80">
  <br/><a href="WelcomeCustomerPage.jsp" ><font style="font-size:18px;">Home Page</font></a>
       
         <!--<div align="left"><ct:UserNameTagHandler/></div> -->
    
        <center><font  color='darkblue' size='+2'>Please provide your touring details:</center>
        <br>
        <br>
        <form action='<c:url value="SessionServlet"/>' name='MyForm' Method='POST'>
           <table cellspacing='10' align='center' border='2' bordercolor='white'>
                <tr>
                    <td bordercolor='white'>Select Destination:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                   <db:DBListTagHandler tablename="Location_Country" colname="Place"></db:DBListTagHandler>
                  </td></tr>            
                <tr><td bordercolor='white'>Select Hotel:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                        <db:DBListTagHandler tablename="Hotels" colname="Hotelname"></db:DBListTagHandler>
                </td></tr>
                
                <tr>
                    <td bordercolor='white'> Start Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="date" name="sdt" style="width: 40%" required>
                    </td>
                </tr>
                <tr>
                    <td bordercolor='white'> End Date:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="date" name="edt" style="width: 40%" required>
                    </td>
                </tr>
                 <tr>
                    <td bordercolor='white'>Select Airline: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <db:DBListTagHandler tablename="Airlines" colname="Airlinename"></db:DBListTagHandler>
                    </td>
                </tr>
                <tr>
                    <td bordercolor='white'>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='submit' Value='Next'></input></a>
                       
                    </td
                </tr>
            </table>
                </form>
        </body>
</html>
