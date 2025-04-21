/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivanfs.agenda.controllers;

import com.ivanfs.agenda.daos.UsuarioDao;
import com.ivanfs.agenda.entities.Usuario;
import jakarta.enterprise.concurrent.ContextService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author carlo
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btn = req.getParameter("btn");
        if (btn.equals("login")) {
            login(req, resp);
        }

        if (btn.equals("register")) {
            resp.sendRedirect("register.jsp");
        }

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario u = usuarioDao.byUsernamePassword(username, password);
         if (username.equals("") || password.equals("")) {
            resp.sendRedirect("vacio.jsp");
        }else if (u != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("identificadorUser", u);
            resp.sendRedirect("home.jsp");
        } else {
            resp.sendRedirect("404.jsp");
        }

    }

}
