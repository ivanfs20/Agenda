<%-- 
    Document   : warning
    Created on : 20 abr 2025, 22:35:28
    Author     : carlo
--%>

<%@page import="com.ivanfs.agenda.entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuario =(Usuario) session.getAttribute("identificadorUser");
    if(usuario==null){
        response.sendRedirect("login.jsp");
    }
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
      <form id="divCenter" action="Delete" method="post" style="background-color: #828DFF">
        <%@include file="./components/warning_title.jsp"%>
        <%@include file="./components/buttons_warning.jsp"%>
    </form>
  </body>
</html>