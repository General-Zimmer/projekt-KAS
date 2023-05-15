package model;

import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Ophold {
    private HotelAftale hotelAftale;
    private Deltager deltager;
    private final ArrayList<TilKøb> tilKøb = new ArrayList<>();
    private LocalDate startDato;
    private int periode;

    public Ophold(HotelAftale hotelAftale, Deltager deltager, LocalDate startDato, int periode) {
        this.hotelAftale = hotelAftale;
        this.deltager = deltager;
        this.startDato = startDato;
        this.periode = periode;
    }

    public HotelAftale getHotelAftale() {
        return hotelAftale;
    }

    public void setHotelAftale(HotelAftale hotelAftale) {
        this.hotelAftale = hotelAftale;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
    }

    public ArrayList<TilKøb> getTilKøb() {
        return tilKøb;
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
}
