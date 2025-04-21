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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author carlo
 */
@WebServlet(name = "Configuration", urlPatterns = {"/Configuration"})
public class ConfigurationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btn = req.getParameter("btn");
        if (btn.equals("update")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            if (username.equals("") || password.equals("")) {
            resp.sendRedirect("vacio.jsp");
            } else {
                UsuarioDao usuarioDao = new UsuarioDao();
                HttpSession session = req.getSession();
                Usuario usuario = (Usuario) session.getAttribute("identificadorUser");
                usuarioDao.updateUser(usuario.getUsername(), usuario.getPassword(), username, password);
                Usuario u = usuarioDao.byUsernamePassword(username, username);
                session.setAttribute("identificadorUser", u);
                resp.sendRedirect("home.jsp");
            }
        } else {
            resp.sendRedirect("home.jsp");
        }
    }

}
