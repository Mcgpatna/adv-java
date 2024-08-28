
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
            <div align="right"><ct:UserNameTagHandler/></div>
       <!-- <table>
            <tr>
                <td width="1%"><font color='darkblue' size='+1'><a href='<c:url value="ConstructionPage.jsp"/>'>Domestic Flights</a></td>
                <td width="1%"><font color='darkblue' size='+1'><a href='<c:url value="ConstructionPage.jsp"/>'>International Flights</a></td>
                <td width="1%"><font color='darkblue' size='+1'><a href='<c:url value="ConstructionPage.jsp"/>'>Hotels</a></td>
                <td width="1%"><font color='darkblue' size='+1'><a href='<c:url value="ConstructionPage.jsp"/>'>Car Rentals</a></td>
                <td width="1%"><font color='darkblue' size='+1'><a href='<c:url value="TourPackage.jsp"/>'>Tour Packages</a></td> 
            </tr>
        </table> -->
            
        <br>
        <font align='center' color='darkblue' size='+1'>Please select the destination where you would like to go:
        <br>
        <br>
        <!--<div class="wrapper fadeInDown"> -->
           <!-- <div id="formContent"> -->
                <form action='<c:url value="SessionServlet"/>' name='MyForm' Method='POST'>
                    <font color='darkblue' size="+2"> Select Destination: </font>
                    <div id=myForm>
<!--                        <select name='Destination' autofocus="true">
                            <option value='Switzerland'>Switzerland</option>
                            <option value='Bahamas'>Bahamas</option>
                            <option value='Thailand'>Thailand</option>
                            <option value='Australia'>Australia</option>
                        </select>-->
                        <db:DBListTagHandler tablename="Location_Country" colname="Place"></db:DBListTagHandler>
                    </div>
                    <input type='hidden' value='Destination' name='PageName'>                            
                    <input type='submit' Value='Next'/>
                </form>
           <!-- </div> -->
       <!-- </div> -->
    </body>
</html>
