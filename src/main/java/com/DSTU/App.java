package com.DSTU;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args){

        List<Solder> solders = new ArrayList<>(XMLParser.getSolder(MyDocument.getDocument("src/main/resources/10var.xml")));

        Sort.sortedSolders(2015, solders);

        Write.writeToXMLSolder(Sort.getSolderByYearOfConscription(2015, solders));
    }

}
