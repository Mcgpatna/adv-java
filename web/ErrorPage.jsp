<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <jsp:include page="Template1.jsp"></jsp:include>
        <td valign='top' rowspan="200" colspan="80">
            <table>
                <tr>
                    <td>
                        <font color='red' size='+2'>Sorry! Blocked access for this IP.
                    </td>
                </tr>
            </table>
            
            <%=request.getParameter("n1") %>
    </body>
</html>
