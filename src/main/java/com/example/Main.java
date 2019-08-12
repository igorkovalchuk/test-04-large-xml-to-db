package com.example;

import java.io.File;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import com.example.entities.ClientTransaction;

public class Main {

    public static void main(String[] args) throws Throwable {
        DatabaseSerializer s = new DatabaseSerializer();
        save("test.xml", s);
    }

    public static void save(String fileName, DatabaseSerializer s) throws XMLStreamException, JAXBException {
        File inputFile = new File(fileName);
        
        s.init();

        // Normally we should read SOAP files using the WSDL and a generated code; but a question that can we use the SAX/StAX-like reading in that case;

        XMLUnserializer u = new XMLUnserializer();
        u.init(inputFile);

        ClientTransaction ct2;

        // Normally we should use batches here, because batches is much faster;
        do {
            ct2 = u.process();
            if (ct2 != null) {
                s.save(ct2);
                //System.out.println(ct2);
            }
        } while(ct2 != null);

        u.close();

        s.close();
    }

}
