package com.DSTU;

import java.util.ArrayList;
import java.util.TreeSet;

public class Sort {
    public TreeSet<Solder> getSolderByYearOfConscription(int year, ArrayList<Solder> allSolders){

        TreeSet<Solder> solders = new TreeSet<>();

        allSolders.forEach(solder -> {
            if (year - solder.getYear() >= 18)
                solders.add(solder);
        });

        return solders;
    }
}
