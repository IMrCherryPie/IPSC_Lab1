package com.DSTU;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class Write {

    static void writeToXMLSolder(Collection<Solder> solders){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<catalog>");

        for (Solder solder: solders) {
            stringBuilder.append("\n\t <solder>");
            stringBuilder.append("\n\t\t <surname>");
            stringBuilder.append(solder.getSurname());
            stringBuilder.append("</surname>");

            stringBuilder.append("\n\t\t <year>");
            stringBuilder.append(solder.getYear());
            stringBuilder.append("</year>");

            stringBuilder.append("\n\t\t <number>");
            stringBuilder.append(solder.getNumber());
            stringBuilder.append("</number>");

            stringBuilder.append("\n\t\t <useful>");
            stringBuilder.append(solder.getUseful());
            stringBuilder.append("</useful>");

            stringBuilder.append("\n\t </solder>");
        }
        stringBuilder.append("\n</catalog>");
        new Write().write(stringBuilder.toString());
    }

    private void write(String string) {
        try (FileWriter writer = new FileWriter("src/main/resources/new.xml", false)) {
            // запись всей строки
            writer.write(string);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
