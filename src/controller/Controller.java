package controller;

import model.Konference;

import java.time.LocalDate;

public abstract class Controller {

    public static Konference createConference(String name, String sted, LocalDate startDate, int periode, float dayPrice) {
        Konference konference = new Konference(name, sted, startDate, periode, dayPrice);

        return konference;
    }

}
