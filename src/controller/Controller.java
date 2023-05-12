package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("unused")
public abstract class Controller {

    /**
     * Create a konference
     */
    public static Konference createKonference(String name, String sted, LocalDate startDate, int periode, float dayPrice) {
        Konference konference = new Konference(name, sted, startDate, periode, dayPrice);

        Storage.addKonference(konference);
        return konference;
    }

    /**
     *
     * Creates Hotel
     */
    public static Hotel createHotel(String name) {
        Hotel hotel = new Hotel(name);
        Storage.addHoteler(hotel);
        return hotel;
    }

    /**
     *
     *
     */
    public static HotelAftale createHotelAftale(int prisDagEnkelt, int prisDagDobbelt, Hotel hotel) {
        return new HotelAftale(prisDagEnkelt, prisDagDobbelt, hotel);
    }

    public static Deltager createDeltager(String name, String telefon, String firma) {
        return (Deltager) Storage.addPerson(new Deltager(name, telefon, firma));
    }

    public static Ledsager createLedsager(String name, String telefon, Deltager deltager) {
        return (Ledsager) Storage.addPerson(new Ledsager(name, telefon, deltager));

    }

    public static UdFlugt createUdflugt(Konference konference, String navn, LocalDate dato, float pris) {
        return Storage.addUdflugt(new UdFlugt(konference, navn, dato, pris));
    }

    public static TilKøb createTilkøb(Hotel hotel, String navn, double pris) {
        TilKøb tilKøb = new TilKøb(navn, pris);
        hotel.addTilkøb(tilKøb);
        return Storage.addTilkøb(tilKøb);
    }

    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteler();
    }

    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    public static ArrayList<TilKøb> getAllTilkøb() {
        return Storage.getTilkøb();
    }

    public static ArrayList<TilKøb> getTilkøb(Hotel hotel) {
        return hotel.getTilkøb();
    }

    public static double getSamletPris(Tilmeld tilmeld) {
        double samletPris = tilmeld.getKonference().getPrisPerDag()*tilmeld.getKonference().getVarighedDage();
        for (Ophold ophold : tilmeld.getOphold()) {
            HotelAftale aftale = ophold.getHotelAftale();
            samletPris += ophold.getPeriode()*(aftale.getPrisDagEnkelt()+aftale.getPrisDagDobbelt());

            for (TilKøb tilKøb : ophold.getTilKøb())
                samletPris += tilKøb.getPris();

            for (UdFlugt udFlugt : tilmeld.getLedsager().getUdFlugter())
                samletPris += udFlugt.getPris();
        }

        return samletPris;
    }
}
