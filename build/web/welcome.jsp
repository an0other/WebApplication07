<%-- 
    Document   : welcome
    Created on : May 26, 2025, 11:17:47 PM
    Author     : an0other
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.UserDTO" %>
<%@page import="util.AuthUtils" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          if(AuthUtils.isLoggedIn(request)){
             UserDTO user = AuthUtils.getCurrentUser(request);
        %>
        <h1>Welcome <%= user.getFullname() %> ! </h1>
        <a href="MainController?action=logout">Logout</a>
        <%} else { %>
            <%=AuthUtils.getAccessDeniedMessage(request,"welcome.jsp")%> <br/>
            (Or <a href="<%=AuthUtils.getLogginURL(request)%>">Login</a>)
        <%}%>
    </body>
</html>
