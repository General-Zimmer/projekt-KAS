package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class HotelAftale {
    private final int prisDagEnkelt;
    private final int prisDagDobbelt;
    private final Hotel hotel;

    public HotelAftale(int prisDagEnkelt, int prisDagDobbelt, Hotel hotel){
        this.prisDagEnkelt = prisDagEnkelt;
        this.prisDagDobbelt = prisDagDobbelt;
        this.hotel = hotel;
    }



    public int getPrisDagEnkelt() {
        return prisDagEnkelt;
    }

    public int getPrisDagDobbelt() {
        return prisDagDobbelt;
    }
    public Hotel getHotel() {
        return hotel;
    }
}
