package storage;

import model.Hotel;
import model.Konference;
import model.Person;

import java.util.ArrayList;

public abstract class Storage {

    public static ArrayList<Konference> konferencer = new ArrayList<>();
    public static ArrayList<Hotel> hoteler = new ArrayList<>();
    public static ArrayList<Person> person = new ArrayList<>();

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
}
