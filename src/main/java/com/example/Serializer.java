package com.example;

import com.example.entities.ClientTransaction;

/**
 * We need it for jUnit tests;
 */
public interface Serializer {

    void init();
    
    void save(ClientTransaction ct);
    
    void close();
}
