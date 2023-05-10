package model;

import javax.xml.stream.Location;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Hotel {
    private String name;
    private String location;

    private Konference konference;
    private ArrayList<HotelAftale> hotelAftale = new ArrayList<>();

    public Hotel(String name, String location){
        this.name = name;
        this.location = location;
    }

    public ArrayList<HotelAftale> getHotelAftale(){
        return new ArrayList<HotelAftale>(hotelAftale);
    }
    public void addHotelAftale(HotelAftale aftale){
        hotelAftale.add(aftale);
    }

    public void setKonference(Konference konference) {
        this.konference = konference;
    }

    public Konference getKonference() {
        return konference;
    }
}
