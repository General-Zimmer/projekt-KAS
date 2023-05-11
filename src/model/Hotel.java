package model;

import javax.xml.stream.Location;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Hotel {
    private String name;
    private final ArrayList<TilKøb> tilkøb = new ArrayList<>();


    public Hotel(String name){
        this.name = name;
    }


}
