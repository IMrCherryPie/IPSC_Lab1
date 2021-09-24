package com.DSTU;

import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) throws SAXException {
        ArrayList<Solder> solders = new ArrayList<>(XMLParser.getSolder());
        sortedSolders(solders);
    }

    public static void sortedSolders(ArrayList<Solder> solders) {
        System.out.println("\nAll solders:\n");
        solders.forEach(System.out::println);
        TreeSet<Solder> set = new TreeSet<>(new Sort().getSolderByYearOfConscription(2015, solders));

        System.out.println("<=========================>");
        System.out.println("\nSolders by year of draft and order: \n");
        set.forEach(System.out::println);
        Write.writeToXMLSolder(set);
    }
}
