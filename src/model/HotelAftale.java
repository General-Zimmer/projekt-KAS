package model;

public class HotelAftale {
    private final int prisDagEnkelt;
    private final int prisDagDobbelt;
    private final Hotel hotel;
    private final Konference konference;

    public HotelAftale(int prisDagEnkelt, int prisDagDobbelt, Hotel hotel, Konference konference) {
        this.prisDagEnkelt = prisDagEnkelt;
        this.prisDagDobbelt = prisDagDobbelt;
        this.hotel = hotel;
        this.konference = konference;
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
