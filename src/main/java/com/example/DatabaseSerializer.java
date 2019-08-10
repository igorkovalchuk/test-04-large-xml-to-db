package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.entities.ClientTransaction;

public class DatabaseSerializer implements Serializer {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void init() {
        emf = Persistence.createEntityManagerFactory("sample");
        em = emf.createEntityManager();
    }

    @Override
    public void save(ClientTransaction ct) {
        em.getTransaction().begin();
        em.persist(ct);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
