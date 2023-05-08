package controller;

import model.Cumferemsæ;

import java.time.LocalDate;

public abstract class Controller {

    public static Cumferemsæ createConference(String name, String sted,LocalDate startDate, int periode, float dayPrice) {
        Cumferemsæ cumferemsæ = new Cumferemsæ(name, sted, startDate, periode, dayPrice);

        return cumferemsæ;
    }

}
