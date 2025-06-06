<%-- 
    Document   : login
    Created on : May 26, 2025, 9:28:06 PM
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
                response.sendRedirect("welcome.jsp");
            }else{

                String message=(String) request.getAttribute("Message");
                if (message==null) message="";
        %>
        <form action="MainController" method="post">
            <input type="hidden" name="action" value="login"/>
            <label for="UserID">UserID</label>
            <input type="text" id="UserID" name="strUserID"/><br>
            <label for="Password">Password</label>
            <input type="password" id="Password" name="strPassword"/><br>
            <input type="submit" value="login"/>
        </form>
        <span style="color : red"><%=message%> </span>
        <%}%>
    </body>
</html>
