package com.DSTU;

import lombok.NonNull;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MyDocument {
    static Document getDocument(@NonNull String path) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = null;
        org.w3c.dom.Document doc = null;

        if (!path.isEmpty()) {
            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                System.out.println("Message: " + e.getMessage());
            }
            try {
                doc = builder.parse(path);
            } catch (SAXException | IOException e) {
                System.out.println("Message: " + e.getMessage());
            }
            return doc;
        }else {
            return null;
        }
    }
}
