

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/cssfile1.css" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="Template1.jsp"></jsp:include>
        
    <center>  <h3 class="active"> Login Form </h3></center>

                <!-- Login Form -->
                <html:form action="/ValidateAction" method="post">
               <table cellspacing='10' align='center'border='2' bordercolor='white'>
                   <tr>
                      <td bordercolor='white'><font color='darkblue'>
                    <B>User ID:</B>
                    <html:text property="emailid" styleClass="fadeIn second" alt="user id"/>
                      </td>
                    </tr>
                    <tr>
                        <td bordercolor='white'><font color='darkblue'>
                            
                    <B>Password:</B>
                    <html:password property="password" styleClass="fadeIn third"/>
                        </td>
                    </tr>
                    <tr>
                        <td bordercolor='white'><font color='darkblue'>
                    <html:radio property="r1" value="administrator"/>Administrator
                    <html:radio property="r1" value="customer" />Customer<br><br>
                        </td>
                    </tr>
                    <tr>
                        <td bordercolor='white'><font color='darkblue'>
                    <input type="submit" class="fadeIn fourth" value="Submit">
                    <input type="reset" class="fadeIn fourth" text="Reset">
                        </td>
                    </tr>
               </table>
                </html:form>
                <br><a href="HomePage.jsp" >Home Page</a>
         
    </body>
</html>
