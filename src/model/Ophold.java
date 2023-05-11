package model;

import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Ophold {
    private HotelAftale hotelAftale;
    private Deltager deltager;
    private final ArrayList<TilKøb> tilKøb = new ArrayList<>();
    private LocalDate startDato;
    private int periode;


}
