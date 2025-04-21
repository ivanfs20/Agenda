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

/**
 *
 * @author carlo
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btn = req.getParameter("btn");
        HttpSession session = req.getSession();
        Usuario usuario = (Usuario) session.getAttribute("identificadorUser");
        if (btn.equals("search")) {
            String search = req.getParameter("input_search");
            if (search.equals("")) {
            resp.sendRedirect("vacio.jsp");
            } else {
                ContactoDao contactoDao = new ContactoDao();
                Contacto contacto = contactoDao.byUsername(search, usuario.getId());
                session.setAttribute("contacto", contacto);
                resp.sendRedirect("open_contact.jsp");
            }
        }
    }

}
