package com.DSTU;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getUseful() {
        return useful;
    }

    public void setUseful(String useful) {
        this.useful = useful;
    }

    @Override
    public String toString() {
        return "Solder{" +
                "name='" + surname + '\'' +
                ", year='" + year + '\'' +
                ", number='" + number + '\'' +
                ", useful='" + useful + '\'' +
                '}';
    }

    public int compareTo(Solder o) {
        return this.year - o.getYear();
    }
}
