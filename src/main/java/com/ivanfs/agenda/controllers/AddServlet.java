/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivanfs.agenda.controllers;

import com.ivanfs.agenda.daos.ContactoDao;
import com.ivanfs.agenda.entities.Contacto;
import com.ivanfs.agenda.entities.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author carlo
 */
@WebServlet(name = "Add", urlPatterns = {"/Add"})
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btn = req.getParameter("btn");
        if (btn.equals("create")) {
            String username = req.getParameter("username");
            String phone = req.getParameter("phone");
            HttpSession session = req.getSession();
            Usuario u = (Usuario) session.getAttribute("identificadorUser");
            LocalDate fecha = LocalDate.now();
            Contacto contacto = new Contacto(username, phone, fecha, u);
            ContactoDao contactoDao = new ContactoDao();
            Contacto uVerifi = contactoDao.byUsername(username, u.getId());

            if (username.equals("") || phone.equals("")) {
                resp.sendRedirect("vacio.jsp");
            } else if (uVerifi != null) {
                resp.sendRedirect("contacto_añadido.jsp");
            } else {
                contactoDao.createContact(contacto);
                session.setAttribute("lista_contactos", contactoDao.byAll(u.getId()));
                resp.sendRedirect("list_contacts.jsp");
            }
        }

        if (btn.equals("home")) {
            resp.sendRedirect("home.jsp");
        }
    }

}
