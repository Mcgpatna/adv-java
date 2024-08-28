

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="CSS/sidebarCSS.css" rel="stylesheet">
        <link href="CSS/cssfile1.css" rel="stylesheet">
    </head>
    <body>
        <div>
            <table border='0' bgcolor='#000080' align='top' width='100%' style='height:100px'>
                <tr>
                    <td bgcolor='#000080' align='center'>
                        <font style='font-family: 'Arial Rounded MT Bold', Gadget, sans-serif;' size='+4' color='#FFE4B5'>Exotica Travels</font>
                    </td>
                    <td bgcolor='#000080' align='left' width='150'>
                        <a href="HomePage.jsp">
                        <img src='Images/CompanyLogo.png' width='200' height='120' align='right' class="image" alt="Home Page"/>
                        </a>
                    </td>
                </tr>
            </table>
        </div>
        
        <div id="sideImage">
            <table bgcolor="white" border="0" align='top' width="100%" style="height: 470px">
                <tr>
                    <td style="width: 216px;" colspan="1" rowspan="4">
                        <img id="imgchng" style="width: 215px; height: 560px;" alt="" src="Images/Sidebar.png">
                    </td>
                </tr>
            </table>
        </div>
        
        <div class="container">
            <nav class="navbar" id="navID">
                <button type="button" onclick="toggleSidebar(this)" class="toggle-collapse" id="toggle-button">
                    <span class="toggle-icon"></span>
                </button>
                
                <ul class="side-nav">
                    <li class="nav-item">
                        <a href="#" class="site-name">Exotica Travels</a>
                    </li>
                    <li class="nav-item">
                                            
                        <!--<a href="#" class="nav-link">Log Out</a> -->
                        
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">My Account</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">Travel Blogs</a>
                    </li>
                    <li class="nav-item">
                        <a href="Contact.jsp" class="nav-link">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">About</a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">FAQs</a>
                    </li>
                </ul>
            </nav>
       </div>
        <script src="javascript/sidebar.js"></script>

    </body>
</html>
