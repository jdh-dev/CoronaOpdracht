package org.example.joshua.corona.model;

import java.util.ArrayList;
import java.util.List;

public class Gast extends Persoon {

    private List<Reservering> reserveringen = new ArrayList<>();

    public Gast(String naam, String telefoonNummer, Huis huis) {
        super(naam, telefoonNummer, huis);
    }

    public List<Reservering> getReserveringen() {
        return reserveringen;
    }

    public void setReserveringen(List<Reservering> reserveringen) {
        this.reserveringen = reserveringen;
    }

    @Override
    public String toString() {
        return "Gast{" +
                "reserveringen=" + reserveringen +
                '}';
    }
}
