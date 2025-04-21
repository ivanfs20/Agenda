<%-- 
    Document   : register
    Created on : 20 abr 2025, 22:09:07
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sess = request.getSession();
    sess.invalidate();
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <link rel="icon" href="./img/icon.png">
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./css/login.css">
    <title>LOGIN</title>
  </head>
  <body>
      <form id="divCenter" action="Register" method="post">
        <%@include file="./components/register_title.jsp"%>
        <%@include file="./components/input_username.jsp"%>
        <%@include file="./components/input_password.jsp"%>
        <%@include file="./components/button_register.jsp"%>
    </form>
  </body>
</html>

