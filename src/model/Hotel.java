package model;

import javax.xml.stream.Location;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Hotel {
    private String name;
    private String location;
    private int oneBedPrice;
    private int twoBedPrice;
    private ArrayList<HotelAftale> HotelAftale = new ArrayList<>();

    public Hotel(String name, String location, int oneBedPrice, int twoBedPrice, ArrayList<HotelAftale> hotelAftale){
        this.name = name;
        this.location = location;
        this.oneBedPrice = oneBedPrice;
        this.twoBedPrice = twoBedPrice;
    }

    public ArrayList<HotelAftale> getHotelAftale(){
        return new ArrayList<HotelAftale>();
    }

}
