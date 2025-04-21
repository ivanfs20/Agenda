<%-- 
    Document   : divContentOpenYes
    Created on : 21 abr 2025, 15:06:52
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="divContentOpen">
    <div style="margin-top:4pc; width:50%">
        <div id="divInformation">
            <div id="divImg">
                <img src="./img/login_user.png" alt="" style="width: 30%;">
            </div>
            <h2><%=contacto.getUsername()%></h2>
            <h2><%=contacto.getPhone()%></h2>
            <h2><%=contacto.getFecha_mod()%></h2>
        </div>
    </div>
    <form id="divToDo" style=" margin-top:4pc" action="Contacto" method="get">
        <h1>TO DO?</h1>
        <div class="divBtnToDo">
            <button class="btnToDo" type="submit" name="btn" value="updateContact">UPDATE</button>
        </div>
        <div class="divBtnToDo">
            <button class="btnToDo" type="submit" name="btn" value="deleteContact">DELETE</button>
        </div>
    </form>
</div>