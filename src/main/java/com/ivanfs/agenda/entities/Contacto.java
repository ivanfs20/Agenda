/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivanfs.agenda.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "CONTACTO")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fecha_mod")
    private LocalDate fecha_mod;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Usuario user;

    public Contacto() {
    }

    public Contacto(String username, String phone, LocalDate fecha_mod, Usuario user) {
        this.username = username;
        this.phone = phone;
        this.fecha_mod = fecha_mod;
        this.user = user;
    }

    public LocalDate getFecha_mod() {
        return fecha_mod;
    }

    public void setFecha_mod(LocalDate fecha_mod) {
        this.fecha_mod = fecha_mod;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

}
