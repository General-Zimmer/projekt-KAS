package storage;

import model.*;

import java.util.ArrayList;

@SuppressWarnings("unused")
public abstract class Storage {

    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Hotel> hoteler = new ArrayList<>();
    private static final ArrayList<Person> personer = new ArrayList<>();
    private static final ArrayList<UdFlugt> udflugter = new ArrayList<>();
    private static final ArrayList<TilKøb> tilKøbene = new ArrayList<>();
    private static final ArrayList<Tilmeld> tilmeldene = new ArrayList<>();


    public static Tilmeld addtilmeld(Tilmeld tilmeld) {
        tilmeldene.add(tilmeld);
        return tilmeld;
    }

    public static ArrayList<Tilmeld> gettilmeldene() {
        return new ArrayList<>(tilmeldene);
    }


    public static TilKøb addTilkøb(TilKøb tilKøb) {
        tilKøbene.add(tilKøb);
        return tilKøb;
    }

    public static ArrayList<TilKøb> getTilkøb() {
        return new ArrayList<>(tilKøbene);
    }

    public static UdFlugt addUdflugt(UdFlugt udFlugt) {
        udflugter.add(udFlugt);
        return udFlugt;
    }

    public static ArrayList<UdFlugt> getUdflugt() {
        return new ArrayList<>(udflugter);
    }

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static Konference addKonference(Konference konferencer) {
        Storage.konferencer.add(konferencer);
        return konferencer;
    }

    public static ArrayList<Hotel> getHoteler() {
        return new ArrayList<>(hoteler);
    }



    public static Hotel addHoteler(Hotel hotel) {
        Storage.hoteler.add(hotel);
        return hotel;
    }

    public static ArrayList<Person> getPersoner() {
        return new ArrayList<>(personer);
    }

    public static Person addPerson(Person person) {
        Storage.personer.add(person);
        return person;
    }


}
