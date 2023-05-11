package model;

@SuppressWarnings("unused")
public abstract class Person {
    private String name;
    private String telefon;

    public Person(String name, String telefon){
        this.name = name;
        this.telefon = telefon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

