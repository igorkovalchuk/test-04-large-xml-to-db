package com.example;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import com.example.entities.ClientTransaction;

public class XMLUnserializer {

    private XMLStreamReader xsr;
    private Unmarshaller unmarshaller;

    public void init(File inputFile) throws XMLStreamException, JAXBException {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource(inputFile);
        xsr = xif.createXMLStreamReader(xml);

        JAXBContext jc = JAXBContext.newInstance(ClientTransaction.class);
        unmarshaller = jc.createUnmarshaller();
        unmarshaller.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
    }

    /**
     * @return ClientTransaction or null
     */
    public ClientTransaction process() throws XMLStreamException, JAXBException {
        boolean found = false;

        while(xsr.hasNext()) {
            int eventType = xsr.nextTag();
            //System.out.println("xsr.getLocalName() = " + xsr.getLocalName());
            if (eventType == XMLStreamConstants.START_ELEMENT && xsr.getLocalName().equals("transaction")) {
                found = true;
                break;
            }
            if (eventType == XMLStreamConstants.END_ELEMENT && xsr.getLocalName().equals("transactions")) {
                break;
            }
        }

        if (found) {
            JAXBElement<ClientTransaction> jb = unmarshaller.unmarshal(xsr, ClientTransaction.class);
            return jb.getValue();
        }

        return null;
    }

    public void close() throws XMLStreamException {
        xsr.close();
    }

}
