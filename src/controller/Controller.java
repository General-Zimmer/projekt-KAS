package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

@SuppressWarnings("unused")
public abstract class Controller {

    /**
     *
     * @param tilmeld
     * @return
     */
    public static double getSamletPris(Tilmeld tilmeld) {
        double samletPris = !tilmeld.isErForedragsholder() ? tilmeld.getKonference().getPrisPerDag()*tilmeld.getPeriode() : 0;
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

    /**
     *
     * @return the created Tilmeld
     */
    public static Tilmeld createTilmeld(Konference konference, boolean erForedragsholder, LocalDate startDato, int periode, Deltager deltager, Ledsager ledsager) {
        LocalDate konStart = konference.getStartDato();
        LocalDate konSlut = konference.getStartDato().plusDays(konference.getVarighedDage());

        if ((konStart.isAfter(startDato) && konSlut.isBefore(startDato)))
            throw new RuntimeException("Cannot create Tilmeldelse");


        return Storage.addtilmeld(new Tilmeld(konference, erForedragsholder, startDato, periode, deltager, ledsager));
    }

    public static Ophold createOphold(Tilmeld tilmeld, HotelAftale hotelAftale, Deltager deltager, LocalDate startDato, int periode) {
        Ophold ophold = new Ophold(hotelAftale, deltager, startDato, periode);
        tilmeld.addOphold(ophold);
        return ophold;
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

    public static Deltager createDeltager(String name, String telefon) {
        return (Deltager) Storage.addPerson(new Deltager(name, telefon));
    }

    public static Ledsager createLedsager(String name, String telefon, Deltager deltager) {
        return (Ledsager) Storage.addPerson(new Ledsager(name, telefon, deltager));

    }

    public static UdFlugt createUdflugt(Konference konference, String navn, LocalDate dato, float pris) {
        return Storage.addUdflugt(new UdFlugt(konference, navn, dato, pris));
    }


    /**
     *
     * @return every tilkøb for the given Hotel
     */
    public static TilKøb createTilkøb(Hotel hotel, String navn, double pris) {
        TilKøb tilKøb = new TilKøb(navn, pris);
        hotel.addTilkøb(tilKøb);
        return Storage.addTilkøb(tilKøb);
    }

    /**
     *
     * @return every deltager
     */
    public static ArrayList<Deltager> getDeltagere() {
        ArrayList<Deltager> deltagers= new ArrayList<>();
        for (Person person : Storage.getPersoner())
            if (person instanceof Deltager deltager)
                deltagers.add(deltager);
        return deltagers;
    }

    /**
     *
     * @return every Ledsager
     */
    public static ArrayList<Ledsager> getLedsager() {
        ArrayList<Ledsager> ledsagere = new ArrayList<>();
        for (Person person : Storage.getPersoner())
            if (person instanceof Ledsager ledsager)
                ledsagere.add(ledsager);
        return ledsagere;
    }

    /**
     * @return every Hotel
     */
    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteler();
    }

    /**
     *
     * @return every konference
     */
    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    /**
     *
     * @return every tilkøb
     */
    public static ArrayList<TilKøb> getAllTilkøb() {
        return Storage.getTilkøb();
    }

    /**
     *
     * @return all tilkøb from Hotel
     */
    public static ArrayList<TilKøb> getTilkøb(Hotel hotel) {
        return hotel.getTilkøb();
    }

    /**
     *
     * Creates Hotel
     * @return Hotel created
     */
    public static Hotel createHotel(String name) {
        return Storage.addHoteler(new Hotel(name));
    }

    /**
     * Create a konference
     * @return created konference
     */
    public static Konference createKonference(String name, String sted, LocalDate startDate, int periode, float dayPrice) {
        return Storage.addKonference(new Konference(name, sted, startDate, periode, dayPrice));
    }

}
