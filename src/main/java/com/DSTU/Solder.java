package com.DSTU;

public class Solder implements Comparable<Solder> {
    private String surname;

    private Integer year;

    private Long number;

    private String useful;

    public void smurtSelct (String nodeName, String item) {
        if ("surname".equals(nodeName)) {
            setSurname(item);
        } else if ("year".equals(nodeName)) {
            setYear((Integer.parseInt(item)));
        } else if ("number".equals(nodeName)) {
            setNumber((long) Integer.parseInt(item));
        } else if ("useful".equals(nodeName)) {
            setUseful(item);
        } else {
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
