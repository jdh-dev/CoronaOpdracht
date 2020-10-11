package org.example.joshua.corona.utility;

import org.example.joshua.corona.model.Reservering;

import java.util.Comparator;

public class ReserveringDatumEnTijdComparator implements Comparator<Reservering> {

    @Override
    public int compare(Reservering r1, Reservering r2) {
        return r1.getReserveringsDatumEnTijd().compareTo(r2.getReserveringsDatumEnTijd());
    }
}
