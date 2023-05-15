package model;

import java.time.LocalDate;
import java.util.ArrayList;
@SuppressWarnings("unused")
public class Tilmeld {

    private final Konference konference;
    private boolean erForedragsholder;
    private LocalDate startDato;
    private int periode;
    private final Deltager deltager;
    private final Ledsager ledsager;
    private final ArrayList<Ophold> ophold = new ArrayList<>();

    public Tilmeld(Konference konference, boolean erForedragsholder, LocalDate startDato, int periode, Deltager deltager, Ledsager ledsager) {
        this.konference = konference;
        this.erForedragsholder = erForedragsholder;
        this.startDato = startDato;
        this.periode = periode;
        this.deltager = deltager;
        this.ledsager = ledsager;
    }

    public void addOphold(Ophold ophold) {
        this.ophold.add(ophold);
    }

    public ArrayList<Ophold> getOphold() {
        return new ArrayList<>(ophold);
    }
    public Konference getKonference() {
        return konference;
    }

    public boolean isErForedragsholder() {
        return erForedragsholder;
    }

    @Override
    public String toString() {
        return
                "konference: " + konference +
                " erForedragsholder: " + erForedragsholder +
                " startDato: " + startDato +
                " periode: " + periode +
                " deltager: " + deltager +
                " ledsager: " + ledsager +
                " ophold: " + ophold;
    }

    public void setErForedragsholder(boolean erForedragsholder) {
        this.erForedragsholder = erForedragsholder;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public int getPeriode() {
        return periode;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }


}
