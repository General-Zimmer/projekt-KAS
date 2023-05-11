package model;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Hotel {
    private String name;
    private final ArrayList<TilKøb> tilkøb = new ArrayList<>();


    public Hotel(String name){
        this.name = name;
    }

    public void addTilkøb(TilKøb tilKøb) {
        this.tilkøb.add(tilKøb);
    }

    public ArrayList<TilKøb> getTilkøb() {
        return new ArrayList<>(tilkøb);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
