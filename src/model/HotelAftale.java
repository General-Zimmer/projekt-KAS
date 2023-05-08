package model;

import java.time.LocalDate;

public class HotelAftale {
    private int oneBedPrice;
    private int twoBedPrice;
    private int periode;
    private LocalDate startDato;
    private Hotel hotel;


    public HotelAftale(int oneBedPrice, int twoBedPrice, int periode, LocalDate startDato, Hotel hotel){
        this.oneBedPrice = oneBedPrice;
        this.twoBedPrice = twoBedPrice;
        this.periode = periode;
        this.startDato = startDato;
        this.hotel = hotel;
    }
}
