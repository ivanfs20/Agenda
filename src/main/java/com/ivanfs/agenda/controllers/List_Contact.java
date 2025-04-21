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

/**
 *
 * @author carlo
 */
@WebServlet(name = "OpenContact", urlPatterns = {"/OpenContact"})
public class List_Contact extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("btnOpenContact"));
        ContactoDao contactoDao = new ContactoDao();
        HttpSession session = req.getSession();
        Contacto contacto = contactoDao.byId(id);
        session.setAttribute("contacto", contacto);
        resp.sendRedirect("open_contact.jsp");
    }

}
