package com.DSTU;

import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) throws SAXException {
        ArrayList<Solder> solders = new ArrayList<>(XMLParser.getSolder());
        System.out.println("\nAll solders:\n");
        System.out.println(solders);
        TreeSet<Solder> set = new TreeSet<>(new Sort().getSolderByYearOfConscription(2015, solders));

        System.out.println("<=========================>");
        System.out.println("\nSolders by year of draft and order: \n");
        for (Object o: set) {
            System.out.println(o);
        }
        Write.writeToXMLSolder(set);
    }
}
