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
        LocalDate startDate = LocalDate.of(2021, 12, 18);

        Konference hav = Controller.createKonference("Hav og Himmel", "Odense Uni", startDate, 3, 1500);
        Konference vand = Controller.createKonference("vand og vandoverflade", "Zimmer Uni", startDate, 3, 9001);

        //--------------------Deltagere-------------------

        Controller.createDeltager("Bob Swanson", "88888888");
        Controller.createDeltager("Scarlet Johanson", "12345678", "Marvel");
        Controller.createDeltager("Big Dick Zimmer", "09127623", "WiseCraft");

        Deltager finn = Controller.createDeltager("Finn Madsen", "yetegr");
        Deltager niels = Controller.createDeltager("Niels Petersen", "rterse");
        Deltager ulla = Controller.createDeltager("Ulla Hansen", "trgsr");
        Deltager peter = Controller.createDeltager("Peter Sommer", "efarf");
        Deltager lone = Controller.createDeltager("Lone Jensen", "grgss");

        //--------------------Ledsager-------------------

        Ledsager hans = Controller.createLedsager("Hans Hansen", "6433578", ulla);
        Ledsager mie = Controller.createLedsager("Mie Sommer", "6433578", peter);
        Ledsager jan = Controller.createLedsager("Jan Madsen", "6433578", lone  );

        //--------------------Udflugter-------------------

        UdFlugt odense = Controller.createUdflugt(hav, "Byrundtur, Odense", startDate, 125);
        UdFlugt ege = Controller.createUdflugt(hav, "Egeskov", startDate, 75);
        UdFlugt trap = Controller.createUdflugt(hav, "Trapholt Museum, Kolding", startDate, 200);

        hans.addUdFlugt(odense);
        mie.addUdFlugt(ege);
        mie.addUdFlugt(trap);
        jan.addUdFlugt(ege);
        jan.addUdFlugt(odense);

        //--------------------Tilmeldinger-------------------

        Tilmeld finTil = Controller.createTilmeld(hav, false, startDate, 3, finn, null);
        Tilmeld NielsTil = Controller.createTilmeld(hav, false, startDate, 3, niels, null);
        Tilmeld ullsaTil = Controller.createTilmeld(hav, false, startDate, 2, ulla, hans);
        Tilmeld peterTil = Controller.createTilmeld(hav, false, startDate, 3, peter, mie);
        Tilmeld loneTil = Controller.createTilmeld(hav, true, startDate, 3, lone, jan);



        //--------------------Hoteller-------------------
        Hotel svane = Controller.createHotel("Den hvide svane");
        Controller.createTilkøb(svane, "Wifi", 50);

        Hotel paradise = Controller.createHotel("Paradise");
        Controller.createTilkøb(paradise,"Wii tank", 50);
        Controller.createTilkøb(paradise,"Warhammer 40k: Dark Tide", 150);
        Controller.createTilkøb(paradise,"Extra blød bed", 9001);
        Controller.createTilkøb(paradise,"pc med RTX 3080TI + 7900x", 10000);
        Controller.createTilkøb(paradise,"Danskvand", 20);
        Controller.createTilkøb(paradise,"Risk of Rain 2", 100);

        //--------------------Ophold-------------------
        HotelAftale doubleBed = Controller.createHotelAftale(0, 1250, svane, hav);
        HotelAftale singleBed = Controller.createHotelAftale(1050, 0, svane, hav);

        Ophold fOphold = Controller.createOphold(finTil, singleBed, finn, startDate, 3);
        Ophold nOphold = Controller.createOphold(NielsTil, singleBed, niels, startDate, 3);
        Ophold uOphold = Controller.createOphold(ullsaTil, doubleBed, ulla, startDate, 2);
        Ophold pOphold = Controller.createOphold(peterTil, doubleBed, peter, startDate, 3);
        Ophold lOphold = Controller.createOphold(loneTil, doubleBed, lone, startDate, 3);


        System.out.println("priser for tilmeldinger\n");

        System.out.println("Finn: " + Controller.getSamletPris(finTil));
        System.out.println("Niels: " + Controller.getSamletPris(NielsTil));
        System.out.println("Ulla: " + Controller.getSamletPris(ullsaTil));
        System.out.println("Peter: " + Controller.getSamletPris(peterTil));
        System.out.println("Lone: " + Controller.getSamletPris(loneTil));




    }
}
