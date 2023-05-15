package model;

import controller.Controller;

import java.time.LocalDate;
import java.util.ArrayList;

public class UdFlugt {
    // Komposition 1..1
    private final Konference konference;
    private String navn;
    private LocalDate Dato;
    private float pris;
    private final ArrayList<Ledsager> ledsagere = new ArrayList<>();

    public UdFlugt(Konference konference, String navn, LocalDate dato, float pris) {
        this.konference = konference;
        this.navn = navn;
        Dato = dato;
        this.pris = pris;
    }

    public ArrayList<Ledsager> getLedsagere() {
        return ledsagere;
    }

    public void addLedsager(Ledsager ledsager) {
        ledsagere.add(ledsager);
    }

    public Konference getKonference() {
        return konference;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDate getDato() {
        return Dato;
    }

    public void setDato(LocalDate dato) {
        Dato = dato;
    }

    public float getPris() {
        return pris;
    }

    public void setPris(float pris) {
        this.pris = pris;
    }
}
