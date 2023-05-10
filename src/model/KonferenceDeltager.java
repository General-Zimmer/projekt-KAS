package model;

import java.util.ArrayList;

public class KonferenceDeltager extends Person{
    private String email;
    private String firma = null;
    private final ArrayList<Tilmeld> tilmeldelser = new ArrayList<>();

    public KonferenceDeltager(String name, int age, String telefon, String email, String firma) {
        super(name, age, telefon);
        this.email = email;
        this.firma = firma;
    }
    public KonferenceDeltager(String name, int age, String telefon, String email) {
        super(name, age, telefon);
        this.email = email;
    }

    public void addTilmeldelse(Tilmeld tilmeldelse) {
        tilmeldelser.add(tilmeldelse);
    }
    public ArrayList<Tilmeld> getTilmeldelser() {
        return new ArrayList<>(tilmeldelser);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
}
