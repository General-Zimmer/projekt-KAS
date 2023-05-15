package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Controller {

    /**
     * Calculates the total cost of a ticket
     * @return the total cost of a ticket.
     */
    public static double getSamletPris(Tilmeld tilmeld) {
        double samletPris = !tilmeld.isErForedragsholder() ? tilmeld.getKonference().getPrisPerDag()*tilmeld.getPeriode() : 0;
        for (Ophold ophold : tilmeld.getOphold()) {
            HotelAftale aftale = ophold.getHotelAftale();
            int opholdsPeriode = ophold.getPeriode()-1; // Hotel ophold betales kun for nætter

            samletPris += opholdsPeriode*(aftale.getPrisDagEnkelt()+aftale.getPrisDagDobbelt());

            for (TilKøb tilKøb : ophold.getTilKøb())
                samletPris += opholdsPeriode*tilKøb.getPris();
        }
        Ledsager ledsager = tilmeld.getLedsager();
        if (ledsager != null)
            for (UdFlugt udFlugt : ledsager.getUdFlugter())
                samletPris += udFlugt.getPris();
        return samletPris;
    }

    /**
     * Creates a tilmelding
     * Note: Can give runtime exceptions. You can find out which error triggered it by the message in the
     * runtime exception. Check code to figure out the exact message given.
     *
     * <p>
     * @return the created Tilmeld
     */
    public static Tilmeld createTilmeld(Konference konference, boolean erForedragsholder, LocalDate startDato, int periode, Deltager deltager, Ledsager ledsager) {
        LocalDate konStart = konference.getStartDato();
        LocalDate konSlut = konference.getStartDato().plusDays(konference.getVarighedDage());

        if ((konStart.isAfter(startDato) && konSlut.isBefore(startDato)))
            throw new RuntimeException("Cannot create Tilmeldelse");

        return Storage.addtilmeld(new Tilmeld(konference, erForedragsholder, startDato, periode, deltager, ledsager));
    }

    /**
     * @return the created Ophold
     */
    public static Ophold createOphold(Tilmeld tilmeld, HotelAftale hotelAftale, Deltager deltager, LocalDate startDato, int periode) {

        Ophold ophold = new Ophold(hotelAftale, deltager, startDato, periode);
        tilmeld.addOphold(ophold);
        return ophold;
    }

    /**
     * @return the created HotelAftale
     */
    public static HotelAftale createHotelAftale(int prisDagEnkelt, int prisDagDobbelt, Hotel hotel, Konference konference) {
        HotelAftale hotelAftale = new HotelAftale(prisDagEnkelt, prisDagDobbelt, hotel, konference);
        konference.addHotelAftale(hotelAftale);
        return hotelAftale;
    }
    /**
     * @return the created Deltager with firma
     */
    public static Deltager createDeltager(String name, String telefon, String firma) {

        return (Deltager) Storage.addPerson(new Deltager(name, telefon, firma));
    }

    /**
     * @return the created Deltager without firma
     */
    public static Deltager createDeltager(String name, String telefon) {
        return (Deltager) Storage.addPerson(new Deltager(name, telefon));
    }

    public static ArrayList<UdFlugt> getUdflugter(Konference konference) {
        return konference.getUdflugter();
    }

    /**
     * @return the created Ledsager
     */
    public static Ledsager createLedsager(String name, String telefon, Deltager deltager) {
        return (Ledsager) Storage.addPerson(new Ledsager(name, telefon, deltager));

    }

    /**
     * @return the created UdFlugt
     */
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
     * @return every Hotel
     */
    public static ArrayList<Hotel> getHoteller(Konference konference) {
        ArrayList<Hotel> hoteller = new ArrayList<>();

        for (HotelAftale hotelAftale : konference.getHotelAftaler()) {
            Hotel hotel = hotelAftale.getHotel();

            if (!hoteller.contains(hotel))
                hoteller.add(hotelAftale.getHotel());
        }
        return hoteller;
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
