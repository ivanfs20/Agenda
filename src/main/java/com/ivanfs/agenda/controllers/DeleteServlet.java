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
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class DeleteServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String btn = req.getParameter("btn");
        if(btn.equals("yes")){
            HttpSession session = req.getSession();
            Contacto contacto = (Contacto)session.getAttribute("contacto");
            ContactoDao contactoDao = new ContactoDao();
            contactoDao.deleteContact(contacto);
            resp.sendRedirect("list_contacts.jsp");
        }else{
            resp.sendRedirect("open_contact.jsp");
        }
    }
    
}
