package com.example;

import org.junit.Test;

import com.example.entities.Client;
import com.example.entities.ClientTransaction;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

public class Test1 {

    private XMLUnserializer u;

    @Before
    public void beforeTest() throws Throwable {
        u = new XMLUnserializer();
        u.init(new File("test.xml"));
    }

    @After
    public void afterTest() throws Throwable {
        u.close();
    }

    @Test
    public void testXMLreading() throws Throwable {
        ArrayList<ClientTransaction> list = new ArrayList<>();
        ClientTransaction ct;

        do {
            ct = u.process();
            if (ct != null) {
                list.add(ct);
            }
        } while(ct != null);

        assertEquals(12, list.size());

        ct = list.get(3);

        /*
                <transaction>
                    <place>A PLACE 4</place>
                    <amount>12.01</amount>
                    <currency>EUR</currency>
                    <card>123456****1234</card>
                    <client>
                        <firstName>Ivan</firstName>
                        <lastName>Ivanoff</lastName>
                        <middleName>Ivanoff</middleName>
                        <inn>1234567890</inn>
                    </client>
                </transaction> 
         */

        assertEquals("A PLACE 4", ct.getPlace());
        assertEquals(12.01, ct.getAmount(), 0);
        assertEquals("EUR", ct.getCurrency());
        assertEquals("123456****1234", ct.getCard());
        assertNotNull(ct.getClient());

        Client c = ct.getClient();
        assertEquals("Ivan", c.getFirstName());
        assertEquals("Ivanoff", c.getLastName());
        assertEquals("Ivanoff", c.getMiddleName());
        assertEquals(1234567890, c.getInn().intValue());

        ct = list.get(11);

/*
                <transaction>
                    <place>A PLACE 12</place>
                    <amount>120</amount>
                    <currency>EUR</currency>
                    <card>123456****1212</card>
                    <client>
                        <firstName>Ivan</firstName>
                        <lastName>Sidorkin</lastName>
                        <middleName>Sidoroff</middleName>
                        <inn>1234567892</inn>
                    </client>
                </transaction>
*/

        assertEquals("A PLACE 12", ct.getPlace());
        assertEquals(120.0, ct.getAmount(), 0);
        assertEquals("EUR", ct.getCurrency());
        assertEquals("123456****1212", ct.getCard());
        assertNotNull(ct.getClient());

        c = ct.getClient();
        assertEquals("Ivan", c.getFirstName());
        assertEquals("Sidorkin", c.getLastName());
        assertEquals("Sidoroff", c.getMiddleName());
        assertEquals(1234567892, c.getInn().intValue());

    }

}
