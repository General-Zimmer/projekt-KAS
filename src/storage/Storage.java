package storage;

import model.Hotel;
import model.Konference;
import model.Person;

import java.util.ArrayList;

public abstract class Storage {

    private static final ArrayList<Konference> konferencer = new ArrayList<>();
    private static final ArrayList<Hotel> hoteler = new ArrayList<>();
    private static final ArrayList<Person> persons = new ArrayList<>();

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void addKonferencer(Konference konferencer) {
        Storage.konferencer.add(konferencer);
    }

    public static ArrayList<Hotel> getHoteler() {
        return new ArrayList<>(hoteler);
    }

    public static void addHoteler(Hotel hotel) {
        Storage.hoteler.add(hotel);
    }

    public static ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    public static void addPerson(Person person) {
        Storage.persons.add(person);
    }


}
