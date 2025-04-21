<%-- 
    Document   : open_contact
    Created on : 21 abr 2025, 10:52:04
    Author     : carlo
--%>

<%@page import="com.ivanfs.agenda.entities.Contacto"%>
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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/open.css">
    <title>HOME</title>
</head>
<body>
    <div id="menu_lateral">
        <div id="bloc">

        </div>

            <div id="information">
                <div id="img_div">
                    <img src="./img/login_user.png" alt="">
                </div>
                <h2 style="font-size: 20pt; color:white"><%=usuario.getUsername()%></h2>
            </div>

        <form id="buttons" action="Home" method="get">
            <div id="div_button">
                <button class="button" type="submit" name="btn" value="back_list">BACK</button>
            </div>
            <div id="div_button">
                <button class="button" type="submit" name="btn" value="logout">LOGOUT</button>
            </div>
        </form>
    </div>
    <%
        Contacto contacto = (Contacto) session.getAttribute("contacto");
        if(contacto!=null){
    %>
        <%@include file="./components/divContentOpenYes.jsp"%>
    <%
        }
    %>
</body>
</html>