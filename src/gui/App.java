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
        paradise.addTilkøb(new TilKøb("Wii tank", 50));
        paradise.addTilkøb(new TilKøb("Warhammer 40k: Dark Tide", 150));
        paradise.addTilkøb(new TilKøb("Extra blød bed", 9001));
        paradise.addTilkøb(new TilKøb("pc med RTX 3080TI + 7900x", 10000));
        paradise.addTilkøb(new TilKøb("Danskvand", 20));
        paradise.addTilkøb(new TilKøb("Risk of Rain 2", 100));

    }
}
