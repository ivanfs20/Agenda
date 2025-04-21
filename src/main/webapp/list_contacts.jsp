<%-- 
    Document   : list_contacts
    Created on : 21 abr 2025, 11:00:28
    Author     : carlo
--%>

<%@page import="com.ivanfs.agenda.daos.ContactoDao"%>
<%@page import="java.util.List"%>
<%@page import="com.ivanfs.agenda.entities.Contacto"%>
<%@page import="com.ivanfs.agenda.entities.Contacto"%>
<%@page import="com.ivanfs.agenda.entities.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("identificadorUser");
    if (usuario == null) {
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/home.css">
        <link rel="stylesheet" href="./css/list.css">

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
                <h2 style="font-size: 20pt; color:white">USERNAME</h2>
            </div>

            <form id="buttons" action="Home" method="get">
                <div id="div_button">
                    <button class="button" name="btn" value="back">BACK</button>
                </div>
                <div id="div_button">
                    <button class="button" name="btn" value="logout">LOGOUT</button>
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

            <div style="display: flex; flex: flex-wrap; justify-content:center; margin-top:1pc">
                <table>
                    <tr>
                        <th>
                            ID
                        </th>
                        <th>
                            USERNAME
                        </th>
                        <th>
                            PHONE
                        </th>
                        <th>
                            DATE_MOD
                        </th>
                        <th>
                            ACTION
                        </th>
                    </tr>

                    <%
                        int i = 1;
                        ContactoDao contactoDao = new ContactoDao();
                        List<Contacto> list = (List<Contacto>) contactoDao.byAll(usuario.getId());
                    %>

                    <%
                        if (list != null) {
                    %>
                    <%
                        for (Contacto c : list) {
                    %>
                    <tr>
                        <td>
                            <%=i%>
                        </td>
                        <td>
                            <%=c.getUsername()%>
                        </td>
                        <td>
                            <%=c.getPhone()%>
                        </td>
                        <td>
                            <%=c.getFecha_mod()%>
                        </td>
                        <td>
                            <form action="OpenContact" method="get">
                                <button name="btnOpenContact" value=<%=c.getId()%> style="background:none;border:none;">
                                    OPEN
                                </button>
                            </form>
                        </td>
                    </tr>
                    <%
                            i++;
                        }
                    %>
                    <%
                        }
                    %>
                </table>
            </div>

            <div id="footer_content">
                <h3>CODE - BACK</h3>
            </div>
        </div>
    </body>
</html>