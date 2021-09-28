package com.DSTU;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.xpath.*;
import java.util.ArrayList;
import java.util.List;

public  class  XPathParser {

    static public List<Solder> getSolder(Document doc) {
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
