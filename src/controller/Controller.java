package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;

public abstract class Controller {

    public static Konference createConference(String name, String sted, LocalDate startDate, int periode, float dayPrice) {
        Konference konference = new Konference(name, sted, startDate, periode, dayPrice);

        Storage.addKonferencer(konference);
        return konference;
    }

    public static Hotel createHotel(String name, String location) {
        Hotel hotel = new Hotel(name, location);
        Storage.addHoteler(hotel);
        return hotel;
    }

    public static Person createPerson(String name, int age, String phone, Role role) {
        Person person = new Person(name, age, phone, role);
        Storage.addPerson(person);
        return person;

    }

    public static HotelAftale createHotelAftale(int oneBedPrice, int twoBedPrice, int periode, LocalDate startDato, Hotel hotel) {
        return new HotelAftale(oneBedPrice, twoBedPrice, periode, startDato, hotel);
    }
}
