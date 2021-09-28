package com.DSTU;

import org.w3c.dom.Document;

import java.util.List;

public class App1 {

    public static void main(String[] args){

        Document doc = MyDocument.getDocument("src/main/resources/10var.xml");

        List<Solder> solders = XPathParser.getSolder(doc);

        Sort.sortedSolders(2015, solders);

        Write.writeToXMLSolder(Sort.getSolderByYearOfConscription(2015, solders));
    }
}
