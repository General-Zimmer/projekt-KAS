package model;

import java.time.LocalDate;

public class HotelAftale {
    private final int oneBedPrice;
    private final int twoBedPrice;
    private int periode;
    private final LocalDate startDato;
    private final Hotel hotel;


    public HotelAftale(int oneBedPrice, int twoBedPrice, int periode, LocalDate startDato, Hotel hotel){
        this.oneBedPrice = oneBedPrice;
        this.twoBedPrice = twoBedPrice;
        this.periode = periode;
        this.startDato = startDato;
        this.hotel = hotel;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public int getOneBedPrice() {
        return oneBedPrice;
    }

    public int getTwoBedPrice() {
        return twoBedPrice;
    }

    public int getPeriode() {
        return periode;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
