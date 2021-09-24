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
import java.util.List;

public class App1 {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        Document doc = getDocument();

        List<Solder> solders = getSolderWithXPath(doc);

        App.sortedSolders((ArrayList<Solder>) solders);
    }

    private static Document getDocument() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc;

        builder = factory.newDocumentBuilder();
        doc = builder.parse("src/main/resources/10var.xml");
        return doc;
    }

    private static List<Solder> getSolderWithXPath(Document doc) {
        // Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
        List<Solder> list = new ArrayList<>();
        try {
            //create XPathExpression object
            XPathExpression expr =
                    xpath.compile("/catalog/solder");
            //evaluate expression result on XML document
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            Solder solder = new Solder();

            for (int i = 0; i < nodes.getLength(); i++) {

                solder.setSurname(xpath.compile("./surname").evaluate(nodes.item(i)));
                solder.setUseful(xpath.compile("./useful").evaluate(nodes.item(i)));
                solder.setNumber(Long.parseLong(xpath.compile("./number").evaluate(nodes.item(i))));
                solder.setYear(Integer.parseInt(xpath.compile("./year").evaluate(nodes.item(i))));

                list.add(solder);

                solder = new Solder();

            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }
}
