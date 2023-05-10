package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class HotelAftale {
    private final int oneBedPrice;
    private final int twoBedPrice;
    private int periode;
    private final LocalDate startDato;
    private final Hotel hotel;
    private final ArrayList<Bekvemelighed> valgteBekvemeligheder = new ArrayList<>();

    public HotelAftale(int oneBedPrice, int twoBedPrice, int periode, LocalDate startDato, Hotel hotel){
        this.oneBedPrice = oneBedPrice;
        this.twoBedPrice = twoBedPrice;
        this.periode = periode;
        this.startDato = startDato;
        this.hotel = hotel;
    }


    public void addBekvemelighed(Bekvemelighed bekvemelighed) {
        valgteBekvemeligheder.add(bekvemelighed);
    }
    public ArrayList<Bekvemelighed> getValgteBekvemeligheder() {
        return new ArrayList<>(valgteBekvemeligheder);
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
