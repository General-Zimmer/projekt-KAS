package gui;

import model.Cumferemsæ;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

    }

    public static void initStorage(){
        //-------------------Hav og himmel--------------
        LocalDate startDate = LocalDate.of(2023,8,01);
        LocalDate endDate = LocalDate.of(2023,8,11);

        Cumferemsæ havOgHimmel = new Cumferemsæ("Hav og Himmel", "Odense Uni", startDate, 10, 1500);

        //--------------------Deltagere-------------------


    }
}
