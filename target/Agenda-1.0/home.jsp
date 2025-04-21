<%-- 
    Document   : home
    Created on : 20 abr 2025, 23:35:52
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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/home.css">
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
                <h2 style="font-size: 15pt; color:white"><%=usuario.getUsername()%></h2>
            </div>

        <form id="buttons" action="Home" method="get">
            <div id="div_button">
                <button class="button" type="submit" name="btn" value="config">CONFIG</button>
            </div>
            <div id="div_button">
                <button class="button" type="submit" name="btn" value="logout">LOGOUT</button>
            </div>
        </form>
    </div>
    <div id="divContent">
        <form id="divSearch" action="Search" method="get">
            <div>
                <input type="text" placeholder="Enter the user to consult..." name="input_search">
            </div>
            <button type="submit" name="btn" value="search" class="button">SEARCH</button>
        </form>
        <div>
            <h1>WHAT DO YOU WANT TO DO?</h1>
        </div>
        <form id="divs_add_see" action="Home" method="post">
            <div id="div_add">
                <h2>ADD</h2>
                <div class="div_img">
                    <button type="submit" name="btn" value="add" class="buttonImg"><img src="./img/home_create.png" alt="" id="img"></button>
                </div>
                <h6>CONTACT</h6>
            </div>
            <div id="div_see">
                <h2>SEE</h2>
                <div class="div_img">
                    <button type="submit" name="btn" value="see" class="buttonImg"><img src="./img/home_listar.png" alt="" id="img"></button>
                </div>
                <h6>CONTACTS</h6>
            </div>
        </form>
        <div id="footer_content">
            <h3>CODE - BACK</h3>
        </div>
    </div>
</body>
</html>
