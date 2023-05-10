package model;

import java.util.ArrayList;

public class ledsager extends Person {
    private KonferenceDeltager konferenceDeltager;
    private final ArrayList<UdFlugt> udFlugter = new ArrayList<>();

    public ledsager(String name, int age, String telefon, KonferenceDeltager konferenceDeltager) {
        super(name, age, telefon);
        this.konferenceDeltager = konferenceDeltager;
    }

    public void addUdFlugt(UdFlugt udFlugt) {
        udFlugter.add(udFlugt);
    }

    public ArrayList<UdFlugt> getUdFlugter() {
        return new ArrayList<>(udFlugter);
    }
}
