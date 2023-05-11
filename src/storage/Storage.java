package storage;

import model.Hotel;
import model.Konference;
import model.Person;
import model.UdFlugt;

import java.util.ArrayList;

@SuppressWarnings("unused")
public abstract class Storage {

    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Hotel> hoteler = new ArrayList<>();
    private static final ArrayList<Person> personer = new ArrayList<>();
    private static final ArrayList<UdFlugt> udflugter = new ArrayList<>();

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

    public static void addKonference(Konference konferencer) {
        Storage.konferencer.add(konferencer);
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
