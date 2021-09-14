package com.DSTU;

import java.util.ArrayList;
import java.util.TreeSet;

public class Sort {
    public TreeSet<Solder> getSolderByYearOfConscription(int year, ArrayList<Solder> allSolders){

        TreeSet<Solder> solders = new TreeSet<Solder>();

        for (int i = 0; i < allSolders.size(); i++) {
            Solder solder = new Solder();
            solder = allSolders.get(i);
            int dif = year - solder.getYear();
            if (dif >= 18){
                solders.add(solder);
            }

        }
        return solders;
    }
}
