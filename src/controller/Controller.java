package controller;

import model.Hotel;
import model.Konference;
import model.Person;
import model.Role;
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

    public static Person CreatePerson(String name, int age, String phone, Role role) {
        Person person = new Person(name, age, phone, role);
        Storage.addPerson(person);
        return person;

    }
}
