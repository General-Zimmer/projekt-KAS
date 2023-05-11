package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;

@SuppressWarnings("unused")
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
        return (Deltager) Storage.addPerson(new Deltager(name, telefon, firma));
    }

    public static Ledsager createLedsager(String name, String telefon, Deltager deltager) {
        return (Ledsager) Storage.addPerson(new Ledsager(name, telefon, deltager));

    }

    public static UdFlugt createUdflugt(Konference konference, String navn, LocalDate dato, float pris) {
        return Storage.addUdflugt(new UdFlugt(konference, navn, dato, pris));
    }
}
