
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel View Page</title>
    </head>
    <body>
        <jsp:include page="Template1.jsp"></jsp:include>
           <td valign="top" rowspan="200" colspan="80">
            <center>
                <% 
                    
                    String role=session.getAttribute("role").toString();
                   String userid=session.getAttribute("User").toString();
                %>
                <form method="post" action="CancelByUser">
            <table cellspacing='10' align='center'border='2' bordercolor='black'>
               <caption style="color:blue; font-size:20px";><b>Tour Cancel Page</b></caption>
                <tr>
                   <td style="color:blue; font-size:20px">Booking Id:</td>
                   <td COLSPAN='2' bordercolor='white'><input type="text" name="bid" required/></td>
                </tr>
                <tr>
                   <td style="color:blue; font-size:20px">Journey Start Date:</td>
                   <td COLSPAN='2' bordercolor='white'><input type="date" name="sdt" required/></td>
                </tr>
                <tr>
                   <td style="color:blue; font-size:20px">Reason for Cancel:</td>
                   <td COLSPAN='2' bordercolor='white'>
                       <textarea rows="3" cols="30" name="creason" required> </textarea>
                   </td>
                </tr>
                <tr>
                    <td style="color:blue; font-size:20px"><input type="submit" value="Submit" /> </td>
                   <td style="color:blue; font-size:20px"><input type="reset" value="Reset" /> </td>
                </tr>
            </table>
           </form>
                <br>
                <br><a href="WelcomeCustomerPage.jsp" ><font style="font-size:18px;">Home Page</font></a>
                <% session.setAttribute("User",userid); %>
            </center>
                
</body>
</html>