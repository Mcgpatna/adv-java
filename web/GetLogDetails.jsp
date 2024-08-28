<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log Details Page</title>
    </head>
    <body>
        <jsp:include page="Template1.jsp"></jsp:include>
        <td valign='top' rowspan="200" colspan="80">
            <table>
                <h1>Testing<br><%=request.getRemoteAddr() %></h1>
                <tr>
                    <td>
                    <jsp:include page="/GetLogDetails">
                        <jsp:param name="title" value="GetLogDetails"/>
                    </jsp:include>
                        
                    </td>
                </tr>
            </table>
                
    </body>
</html>
