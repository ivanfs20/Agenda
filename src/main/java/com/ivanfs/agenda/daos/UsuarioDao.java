/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivanfs.agenda.daos;

import com.ivanfs.agenda.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

/**
 *
 * @author carlo
 */
public class UsuarioDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexion");

    //CREAR ENTITYMANAGER
    private EntityManager entityManager() {
        return emf.createEntityManager();
    }

    //CREARUSUARIO
    public void createUser(Usuario usuario) {
        EntityManager manager = entityManager();
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        manager.close();
    }
    //OBTENER USUARIO POR USERNAME - PASSWORD

    public Usuario byUsernamePassword(String usuario, String contraseña) {
        EntityManager manager = entityManager();
        try {
            Usuario user = manager.createQuery(
                    "SELECT u FROM Usuario u WHERE u.username = :usuario AND u.password = :contraseña",
                    Usuario.class
            )
                    .setParameter("usuario", usuario)
                    .setParameter("contraseña", contraseña)
                    .getSingleResult();

            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            manager.close();
        }
    }

    //MODIFICAR USUARIO POR USERNAME - PASSWORD
    public void updateUser(String usuarioA, String contraseñaA, String usuarioN, String contraseñaN) {
        EntityManager manager = entityManager();
        try {
            manager.getTransaction().begin();

            Usuario user = manager.createQuery(
                    "SELECT u FROM Usuario u WHERE u.username = :usuario AND u.password = :contraseña",
                    Usuario.class
            )
                    .setParameter("usuario", usuarioA)
                    .setParameter("contraseña", contraseñaA)
                    .getSingleResult();

            user.setUsername(usuarioN);
            user.setPassword(contraseñaN);

            manager.merge(user);
            manager.getTransaction().commit();

        } catch (NoResultException e) {

        } finally {
            manager.close();
        }
    }

}
