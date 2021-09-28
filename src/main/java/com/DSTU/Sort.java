package com.DSTU;

import java.util.*;

public class Sort {

    public static void sortedSolders(int year, Collection<Solder> solders) {

        System.out.println("\nAll solders:\n");
        solders.forEach(System.out::println);

        TreeSet<Solder> set = new TreeSet<>(Sort.getSolderByYearOfConscription(year, solders));

        System.out.println("<=========================>");
        System.out.println("\nSolders by year of draft and order: \n");
        set.forEach(System.out::println);
    }

    public static Collection<Solder> getSolderByYearOfConscription(int year, Collection<Solder> allSolders){

        Set<Solder> solders = new TreeSet<>();

        allSolders.forEach(solder -> {
            if (year - solder.getYear() >= 18)
                solders.add(solder);
        });

        return solders;
    }
}
