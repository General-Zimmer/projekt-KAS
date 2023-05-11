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

    public static Hotel createHotel(String name, String location) {
        Hotel hotel = new Hotel(name, location);
        Storage.addHoteler(hotel);
        return hotel;
    }

    public static HotelAftale createHotelAftale(int oneBedPrice, int twoBedPrice, int periode, LocalDate startDato, Hotel hotel) {
        return new HotelAftale(oneBedPrice, twoBedPrice, periode, startDato, hotel);
    }

    public static Deltager createDeltager(String name, int age, String telefon, String email, String firma) {
        Deltager deltager = new Deltager(name, age, telefon, email, firma);
        Storage.addPerson(deltager);
        return deltager;
    }

    public static Ledsager createLedsager(String name, int age, String telefon, Deltager deltager) {
        Ledsager ledsager = new Ledsager(name, age, telefon, deltager);
        Storage.addPerson(ledsager);
        return ledsager;
    }
}
