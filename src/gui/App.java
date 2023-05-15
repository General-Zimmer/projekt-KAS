package gui;

import controller.Controller;
import model.*;

import java.time.LocalDate;

import javafx.application.Application;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);
    }

    public static void initStorage(){
        //-------------------Hav og himmel--------------
        LocalDate startDate = LocalDate.of(2023,8, 1);

        Konference hav = Controller.createKonference("Hav og Himmel", "Odense Uni", startDate, 10, 1500);

        //--------------------Deltagere-------------------

        Controller.createDeltager("Bob Swanson", "88888888");
        Controller.createDeltager("Scarlet Johanson", "12345678", "Marvel");
        Controller.createDeltager("Big Dick Zimmer", "09127623", "WiseCraft");

        Deltager finn = Controller.createDeltager("Finn Madsen", "yetegr");
        Controller.createDeltager("Niels Petersen", "rterse");
        Controller.createDeltager("Ulla Hansen", "trgsr");
        Controller.createDeltager("Peter Sommer", "efarf");
        Controller.createDeltager("Lone Jensen", "grgss");

        Ledsager mads = Controller.createLedsager("Mads Madsen", "6433578", finn);
        //--------------------Smol test-------------------

        LocalDate tilmeldStart = LocalDate.of(2023,8, 2);

        Tilmeld madsTil = Controller.createTilmeld(hav, false, tilmeldStart, 3, finn, mads);
        System.out.println("Mads som normal deltager");
        System.out.println(Controller.getSamletPris(madsTil));
        System.out.println("Mads som fordragsholder");
        madsTil.setErForedragsholder(true);
        System.out.println(Controller.getSamletPris(madsTil));

        //--------------------Hoteller-------------------
        Hotel svane = Controller.createHotel("Den hvide svane");
        Controller.createTilkøb(svane, "Mad", 50);

        Hotel paradise = Controller.createHotel("Paradise");
        Controller.createTilkøb(paradise,"Wii tank", 50);
        Controller.createTilkøb(paradise,"Warhammer 40k: Dark Tide", 150);
        Controller.createTilkøb(paradise,"Extra blød bed", 9001);
        Controller.createTilkøb(paradise,"pc med RTX 3080TI + 7900x", 10000);
        Controller.createTilkøb(paradise,"Danskvand", 20);
        Controller.createTilkøb(paradise,"Risk of Rain 2", 100);

        //--------------------Ophold-------------------
        HotelAftale doubleBed = Controller.createHotelAftale(0, 700, svane, hav);
        HotelAftale singleBed = Controller.createHotelAftale(100, 0, paradise, hav);

        Ophold fOphold = Controller.createOphold(madsTil, singleBed, finn, tilmeldStart, 3);


        for (TilKøb tilKøb : fOphold.getHotelAftale().getHotel().getTilkøb()) {
            fOphold.addTilkøb(tilKøb);
        }

        System.out.println("\npris test med ophold\n");

        System.out.println("Mads som normal deltager");
        madsTil.setErForedragsholder(false);
        System.out.println(Controller.getSamletPris(madsTil));
        System.out.println("Mads som fordragsholder");
        madsTil.setErForedragsholder(true);
        System.out.println(Controller.getSamletPris(madsTil));


    }
}
