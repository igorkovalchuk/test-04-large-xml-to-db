package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.entities.ClientTransaction;

public class DatabaseSerializer {

    private static final int BATCH_SIZE = 200; // same as the JDBC batch size

    private EntityManagerFactory emf;
    private EntityManager em;

    private int i = 0;

    public void init() {
        emf = Persistence.createEntityManagerFactory("sample");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void save(ClientTransaction ct) {
        em.persist(ct);
        i++;

        if (i % BATCH_SIZE == 0) {
            System.out.println("batch ... ... ... ... ... ... ... flush, clear, size = " + BATCH_SIZE);
            em.flush();
            em.clear();
        }
    }

    public void close() {
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
