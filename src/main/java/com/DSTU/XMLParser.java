package com.DSTU;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class XMLParser {

    public static ArrayList<Solder> getSolder() throws SAXException {

        ArrayList<Solder> solders = new ArrayList<Solder>();
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("src/main/resources/10var.xml");

            // Получаем корневой элемент
            Node root = document.getDocumentElement();

//            System.out.println("List of solder:");
            System.out.println();
            // Просматриваем все подэлементы корневого - т.е. солдата
            NodeList solder = root.getChildNodes();
            for (int i = 0; i < solder.getLength(); i++) {
                Node book = solder.item(i);
                // Если нода не текст, то это солдат - заходим внутрь
                if (book.getNodeType() != Node.TEXT_NODE) {
                    NodeList solderProps = book.getChildNodes();
                    Solder solder1 = new Solder();
                    for (int j = 0; j < solderProps.getLength(); j++) {
                        Node solderProp = solderProps.item(j);
                        // Если нода не текст, то это один из параметров солдата - печатаем
                        if (solderProp.getNodeType() != Node.TEXT_NODE) {
//                            System.out.println(solderProp.getNodeName() + ":" + solderProp.getChildNodes().item(0).getTextContent());
                            solder1.smurtSelct(solderProp.getNodeName(), solderProp.getChildNodes().item(0).getTextContent());
                        }
                    }
//                    System.out.println("===========>>>>");
                    solders.add(solder1);
                }
            }

        } catch (ParserConfigurationException | IOException ex) {
            ex.printStackTrace(System.out);
        }

//        System.out.println("------------------------");
//        System.out.println(solders);
        return solders;
    }
}
