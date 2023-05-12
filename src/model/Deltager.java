package model;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Deltager extends Person{
    private String firma = null;
    private final ArrayList<Tilmeld> tilmeldelser = new ArrayList<>();



    public Deltager(String name, String telefon, String firma) {
        super(name, telefon);
        this.firma = firma;
    }
    public Deltager(String name, String telefon) {
        super(name, telefon);
    }

    


    public void addTilmeldelse(Tilmeld tilmeldelse) {
        tilmeldelser.add(tilmeldelse);
    }
    public ArrayList<Tilmeld> getTilmeldelser() {
        return new ArrayList<>(tilmeldelser);
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }
}
