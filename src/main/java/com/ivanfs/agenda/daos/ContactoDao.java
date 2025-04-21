/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivanfs.agenda.daos;

import com.ivanfs.agenda.entities.Contacto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

/**
 *
 * @author carlo
 */
public class ContactoDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexion");

    //CREAR ENTITYMANAGER
    private EntityManager entityManager() {
        return emf.createEntityManager();
    }

    //CREAR CONTACTO
    public void createContact(Contacto contacto) {
        EntityManager manager = entityManager();
        manager.getTransaction().begin();
        manager.persist(contacto);
        manager.getTransaction().commit();
        manager.close();
    }

    //MODIFICAR CONTACTO
    public void updateContact(Contacto contacto) {
        EntityManager manager = entityManager();
        manager.getTransaction().begin();
        manager.merge(contacto);
        manager.getTransaction().commit();
        manager.close();
    }

    public Contacto byId(Long id) {
        EntityManager manager = entityManager();
        Contacto contacto = manager.find(Contacto.class, id);
        manager.close();
        return contacto;
    }

    //BUSCAR CONTACTO POR NOMBRE
    public Contacto byUsername(String username, Long id_user) {
        EntityManager manager = entityManager();
        try {
            Contacto contact = manager.createQuery("SELECT c FROM Contacto c WHERE c.username=:username AND c.user.id =:id", Contacto.class).setParameter("username", username).setParameter("id", id_user).getSingleResult();
            return contact;
        } catch (Exception e) {
            return null;
        } finally {
            manager.close();
        }
    }

    public List<Contacto> byAll(Long id_user) {
        EntityManager manager = entityManager();
        try {
            List<Contacto> contact = manager.createQuery("SELECT c FROM Contacto c WHERE c.user.id =:id", Contacto.class).setParameter("id", id_user).getResultList();
            return contact;
        } catch (Exception e) {
            return null;
        } finally {
            manager.close();
        }
    }

    //ELIMINAMOS EL CONTACTO
    public void deleteContact(Contacto contacto) {
        EntityManager manager = entityManager();
        manager.getTransaction().begin();
        manager.remove(manager.merge(contacto));
        manager.getTransaction().commit();
        manager.close();
    }

}
