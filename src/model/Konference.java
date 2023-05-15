package model;

import java.time.LocalDate;
import java.util.ArrayList;
// metoderne til oversigter over tilmeldelser og udflugter kan være her i
@SuppressWarnings("unused")
public class Konference {
    private String navn;
    private String sted;
    private LocalDate startDato;
    private int varighedDage;
    private float prisPerDag;
    private final ArrayList<HotelAftale> hotelAftaler = new ArrayList<>();
    private final ArrayList<UdFlugt> udFlugter = new ArrayList<>();
    private final ArrayList<Person> personer = new ArrayList<>();

    public Konference(String navn, String sted, LocalDate startDato, int varighedDage, float prisPerDag) {
        this.navn = navn;
        this.sted = sted;
        this.startDato = startDato;
        this.varighedDage = varighedDage;
        this.prisPerDag = prisPerDag;
    }

    public void addPerson(Person person) {
        personer.add(person);
    }
    public void removePerson(Person person) {
        personer.remove(person);
    }

    public ArrayList<Person> getPersoner() {
        return new ArrayList<>(personer);
    }

    public ArrayList<UdFlugt> getUdflugter() {
        return new ArrayList<>(udFlugter);
    }

    public void addHotelAftale(HotelAftale hotelAftale) {
        hotelAftaler.add(hotelAftale);
    }
    public ArrayList<HotelAftale> getHotelAftaler() {
        return new ArrayList<>(hotelAftaler);
    }

    public LocalDate getSlutDato() {
        return startDato.plusDays(varighedDage);
    }

    public String getSted() {
        return sted;
    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getVarighedDage() {
        return varighedDage;
    }

    public void setVarighedDage(int varighedDage) {
        this.varighedDage = varighedDage;
    }

    public double getPrisPerDag() {
        return prisPerDag;
    }

    public void setPrisPerDag(float prisPerDag) {
        this.prisPerDag = prisPerDag;
    }

    @Override
    public String toString() {
        return
                "navn: " + navn +
                " sted: " + sted  +
                " startDato: " + startDato +
                " varighedDage: " + varighedDage +
                " prisPerDag: " + prisPerDag;
    }
}
