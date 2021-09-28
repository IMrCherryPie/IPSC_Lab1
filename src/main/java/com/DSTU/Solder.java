package com.DSTU;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solder implements Comparable<Solder> {
    private String surname;

    private Integer year;

    private Long number;

    private String useful;


    public void smartSelect(String nodeName, String item) {

        switch (nodeName){
            case "surname":
                setSurname(item);
                break;
            case "year":
                setYear((Integer.parseInt(item)));
                break;

            case "number":
                setNumber((long) Integer.parseInt(item));
                break;

            case "useful":
                setUseful(item);
                break;
            default:
                System.out.println("Не предусмотрено поле -> " + nodeName);


        }
    }

    public int compareTo(Solder o) {
        return this.year - o.getYear();
    }
}
