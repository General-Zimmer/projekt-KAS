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

    public String getNavn() {
        return super.getName();
    }
    public String getTelefon(){
        return super.getTelefon();
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

    @Override
    public String toString() {
        return "Navn: " + getNavn() + " tlf: " + getTelefon() +
                " Firma: " + firma;
    }
}
