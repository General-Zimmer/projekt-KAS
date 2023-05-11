package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;

public abstract class Controller {

    public static Konference createKonference(String name, String sted, LocalDate startDate, int periode, float dayPrice) {
        Konference konference = new Konference(name, sted, startDate, periode, dayPrice);

        Storage.addKonference(konference);
        return konference;
    }

    public static Hotel createHotel(String name) {
        Hotel hotel = new Hotel(name);
        Storage.addHoteler(hotel);
        return hotel;
    }

    public static HotelAftale createHotelAftale(int prisDagEnkelt, int prisDagDobbelt, Hotel hotel) {
        return new HotelAftale(prisDagEnkelt, prisDagDobbelt, hotel);
    }

    public static Deltager createDeltager(String name, String telefon, String firma) {
        Deltager deltager = new Deltager(name, telefon, firma);
        Storage.addPerson(deltager);
        return deltager;
    }

    public static Ledsager createLedsager(String name, String telefon, Deltager deltager) {
        Ledsager ledsager = new Ledsager(name, telefon, deltager);
        Storage.addPerson(ledsager);
        return ledsager;
    }
}
