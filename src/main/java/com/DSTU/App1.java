package com.DSTU;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App1 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;

        builder = factory.newDocumentBuilder();
        doc = builder.parse("src/main/resources/10var.xml");

        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();

        System.out.println(getSolder(doc, xpath));
    }

    private static ArrayList<Solder> getSolder(Document doc, XPath xpath) {
        ArrayList<Solder> list = new ArrayList<>();
        try {
            //create XPathExpression object
            XPathExpression expr =
                    xpath.compile("/catalog/solder/*/text()");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            ArrayList<Solder> solders = new ArrayList<>();

            Solder solder = new Solder();

            for (int i = 0; i < nodes.getLength(); i++) {
//                nodes.item(i).getNodeValue();

                solder.smurtSelct(nodes.item(i).getNodeName(), nodes.item(i).getTextContent());
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }
}
