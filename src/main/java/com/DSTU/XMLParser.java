package com.DSTU;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Collection;

public class XMLParser {

    public static Collection<Solder> getSolder(Document doc) {

        Collection<Solder> solders = new ArrayList<>();

        // Получаем корневой элемент
        if (doc!=null){
            Node root = doc.getDocumentElement();

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
                            solder1.smartSelect(solderProp.getNodeName(), solderProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                    solders.add(solder1);
                }
            }
        }else{
            System.out.println("Документ пустой");
        }

        return solders;
    }
}
