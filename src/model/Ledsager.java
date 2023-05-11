package model;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Ledsager extends Person {
    private Deltager deltager;
    private final ArrayList<UdFlugt> udFlugter = new ArrayList<>();

    public Ledsager(String name, String telefon, Deltager deltager) {
        super(name, telefon);
        this.deltager = deltager;
    }

    public void addUdFlugt(UdFlugt udFlugt) {
        udFlugter.add(udFlugt);
    }

    public ArrayList<UdFlugt> getUdFlugter() {
        return new ArrayList<>(udFlugter);
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
    }
}
