package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tilmeld {
    private LocalDate startDato;
    private int periode;
    private Role role;
    private final ArrayList<Bekvemelighed> bekvemeligheder = new ArrayList<>();
}
