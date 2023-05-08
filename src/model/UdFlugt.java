package model;

import java.time.LocalDate;

public class UdFlugt {
    // Komposition 1..1
    private final Cumferemsæ cumferemsæ;
    private String navn;
    private LocalDate Dato;
    private float pris;

    public UdFlugt(Cumferemsæ cumferemsæ, String navn, LocalDate dato, float pris) {
        this.cumferemsæ = cumferemsæ;
        this.navn = navn;
        Dato = dato;
        this.pris = pris;
    }




    public Cumferemsæ getCumferemsæ() {
        return cumferemsæ;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDate getDato() {
        return Dato;
    }

    public void setDato(LocalDate dato) {
        Dato = dato;
    }

    public float getPris() {
        return pris;
    }

    public void setPris(float pris) {
        this.pris = pris;
    }
}
