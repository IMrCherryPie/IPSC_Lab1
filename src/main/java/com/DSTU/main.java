package com.DSTU;

import com.sun.org.apache.xalan.internal.res.XSLTErrorResources_sv;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class main {

    public static void main(String[] args) throws SAXException {
        ArrayList<Solder> solders = new ArrayList<Solder>(DomXMLParser.getSolder());
//        System.out.println(solders);
        Set set = new TreeSet<Solder>(new Sort().getSolderByYearOfConscription(2015, solders));

        for (Object o: set) {
            System.out.println(o);
        }
    }
}
