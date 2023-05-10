package gui;

import model.Konference;

import java.time.LocalDate;

import javafx.application.Application;
import model.Person;

public class App {
    public static void main(String[] args) {
        Application.launch(Gui.class);
    }

    public static void initStorage(){
        //-------------------Hav og himmel--------------
        LocalDate startDate = LocalDate.of(2023,8,01);
        LocalDate endDate = LocalDate.of(2023,8,11);

        Konference havOgHimmel = new Konference("Hav og Himmel", "Odense Uni", startDate, 10, 1500);

        //--------------------Deltagere-------------------
        Person p1 = new Person("Bob", 38, "88888888", "Deltager");
        Person p2 = new Person("Alice" 12, "99999999", "Deltager");
        Person p3 = new Person("Bruce" 99, "12345678", "Foredragsholder");

    }
}
