/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivanfs.agenda.controllers;

import com.ivanfs.agenda.daos.ContactoDao;
import com.ivanfs.agenda.entities.Contacto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 * @author carlo
 */
@WebServlet(name = "Contacto", urlPatterns = {"/Contacto"})
public class ContactoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btn = req.getParameter("btn");
        if (btn.equals("updateContact")) {
            resp.sendRedirect("update.jsp");
        }

        if (btn.equals("deleteContact")) {
            resp.sendRedirect("warning.jsp");
        }

        if (btn.equals("update")) {
            HttpSession session = req.getSession();
            String username = req.getParameter("username");
            String phone = req.getParameter("phone");
            if (username.equals("") || phone.equals("")) {
            resp.sendRedirect("vacio.jsp");
            } else {
                Contacto contacto = (Contacto) session.getAttribute("contacto");
                contacto.setUsername(username);
                contacto.setPhone(phone);
                contacto.setFecha_mod(LocalDate.now());
                ContactoDao contactoDao = new ContactoDao();
                contactoDao.updateContact(contacto);
                resp.sendRedirect("open_contact.jsp");
            }
        }

        if (btn.equals("home")) {
            resp.sendRedirect("home.jsp");
        }
    }

}
