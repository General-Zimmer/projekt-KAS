package gui;

import controller.Controller;
import model.Hotel;
import model.Konference;

import java.time.LocalDate;

import javafx.application.Application;
import model.TilKøb;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);
    }

    public static void initStorage(){
        //-------------------Hav og himmel--------------
        LocalDate startDate = LocalDate.of(2023,8, 1);

        Controller.createKonference("Hav og Himmel", "Odense Uni", startDate, 10, 1500);

        //--------------------Deltagere-------------------

        Hotel paradise = Controller.createHotel("Paradise");
        Controller.createTilkøb(paradise,"Wii tank", 50);
        Controller.createTilkøb(paradise,"Warhammer 40k: Dark Tide", 150);
        Controller.createTilkøb(paradise,"Extra blød bed", 9001);
        Controller.createTilkøb(paradise,"pc med RTX 3080TI + 7900x", 10000);
        Controller.createTilkøb(paradise,"Danskvand", 20);
        Controller.createTilkøb(paradise,"Risk of Rain 2", 100);

        Controller.createDeltager("Bob Swanson", "88888888"," ");
        Controller.createDeltager("Scarlet Johanson", "12345678", "Marvel");
        Controller.createDeltager("Big Dick Zimmer", "09127623", "WiseCraft");

    }
}
