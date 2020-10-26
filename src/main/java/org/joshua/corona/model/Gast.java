package org.joshua.corona.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gast extends Persoon {

    private List<Reservering> reserveringen = new ArrayList<>();

    public Gast(String naam, String telefoonNummer, Huis huis) {
        super(naam, telefoonNummer, huis);
    }

    public List<Reservering> getReserveringen() {
        if (reserveringen == null) {
            return Collections.emptyList();
        }
        return reserveringen;
    }

    @Override
    public String toString() {
        return "Gast{" +
                "reserveringen=" + reserveringen +
                '}';
    }
}
