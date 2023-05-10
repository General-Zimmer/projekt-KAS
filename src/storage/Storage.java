package storage;

import model.Hotel;
import model.Konference;
import model.Person;

import java.util.ArrayList;

public abstract class Storage {

    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Hotel> hoteler = new ArrayList<>();
    private static final ArrayList<Person> personer = new ArrayList<>();

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void addKonference(Konference konferencer) {
        Storage.konferencer.add(konferencer);
    }

    public static ArrayList<Hotel> getHoteler() {
        return new ArrayList<>(hoteler);
    }

    public static void addHoteler(Hotel hotel) {
        Storage.hoteler.add(hotel);
    }

    public static ArrayList<Person> getPersoner() {
        return new ArrayList<>(personer);
    }

    public static void addPerson(Person person) {
        Storage.personer.add(person);
    }


}
