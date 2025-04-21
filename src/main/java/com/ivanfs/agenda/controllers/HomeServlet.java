/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivanfs.agenda.controllers;

import com.ivanfs.agenda.daos.ContactoDao;
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
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btn = req.getParameter("btn");
        if (btn.equals("config")) {
            resp.sendRedirect("configuration.jsp");
        }
        if (btn.equals("logout")) {
            resp.sendRedirect("login.jsp");
        }

        if (btn.equals("search")) {
            resp.sendRedirect("open_contact.jsp");
        }
        
        if(btn.equals("back")){
            resp.sendRedirect("home.jsp");
        }
        
        if(btn.equals("back_list")){
            resp.sendRedirect("list_contacts.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btn = req.getParameter("btn");

        if (btn.equals("add")) {
            resp.sendRedirect("add.jsp");
        }

        if (btn.equals("see")) {
            HttpSession session = req.getSession();
            ContactoDao contactoDao = new ContactoDao();
            Usuario u = (Usuario) session.getAttribute("identificadorUser");
            session.setAttribute("lista_contactos", contactoDao.byAll(u.getId()));
            resp.sendRedirect("list_contacts.jsp");
        }
    }

}
