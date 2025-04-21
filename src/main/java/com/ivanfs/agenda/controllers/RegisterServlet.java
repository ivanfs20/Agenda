/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivanfs.agenda.controllers;

import com.ivanfs.agenda.daos.UsuarioDao;
import com.ivanfs.agenda.entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author carlo
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btn = req.getParameter("btn");
        if (btn.equals("register")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario user = usuarioDao.byUsernamePassword(username, password);
            if (username.equals("") || password.equals("")) {
                resp.sendRedirect("vacio.jsp");
            }else if (user != null) {
                resp.sendRedirect("user_registrado.jsp");
            } else {
                Usuario newUsuario = new Usuario(username, password);
                usuarioDao.createUser(newUsuario);
                resp.sendRedirect("login.jsp");
            }

        }
    }
}
