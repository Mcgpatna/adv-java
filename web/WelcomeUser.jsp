
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html14/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <jsp:include page="Template1.jsp"></jsp:include>
        <td valign="top" rowspan="200" colspan="80">
            <table>
                <tr>
                    <td>
                        <c:set var="message" value="${requestScope.NewUser}" />
                        <font color="darkblue" size="+2">Welcome to Exotica Travels <c:out value="${message}" />. You have registered successfully.</font>
                    </td> 
                </tr>
                <tr>
                    <td width="1%"><font color='darkblue' size='+1'>
                            <a href='<c:url value="LoginPage.jsp"/>'>Login</a>
                    </td>
                </tr>
            </table>
    </body>
</html>
