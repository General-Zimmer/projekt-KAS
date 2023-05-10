package model;

public class Person {
    private String name;
    private String telefon;
    private int age;
    private String firma = null;


    public Person(String name, int age, String telefon){
        this.name = name;
        this.age = age;
        this.telefon = telefon;
    }
    public Person(String name, int age, String telefon, String firma){
        this.name = name;
        this.age = age;
        this.telefon = telefon;
        this.firma = firma;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

