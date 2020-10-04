package org.example.joshua.corona.model;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class GastenLijstManager {

    private GastenLijst gastenLijst = new GastenLijst();
    public static final String DATE_TIME_PATTERN = "dd-MM-yyyy hh:mm";
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);

    /**
     * Deze methode behandelt alle inkomende reserveringen
     * @param reservering
     */
    public void behandelInkomendeReservering(Reservering reservering) {
        if(reservering == null) {
            System.out.println("Reservering is niet goedgekeurd");
            return;
        }
        if (gastenLijst.bestaatReserveringAlOpDatumEnTijd(reservering.getReserveringsDatumEnTijd())) {
            System.out.println("Kan niet reserveren op dit tijdstip");
        } else {
            reservering.setGeaccepteerd(true);
            gastenLijst.voegReserveringToe(reservering);
            System.out.println("Reservering is goedgekeurd en staat vast op " + reservering.getReserveringsDatumEnTijd().format(formatter));
        }
    }

    /**
     * Deze methode haalt alle reserveringen op van een specifieke dag
     * @param reserveringsDatum
     * @return
     */
    public Collection<Reservering> getReserveringenOpDatum(LocalDate reserveringsDatum) {
        if(gastenLijst.getReserveringen().containsKey(reserveringsDatum)) {
            return gastenLijst.getReserveringen().get(reserveringsDatum);
        }
        System.out.println("Geen reserveringen op deze datum gevonden");
        return null;
    }

    public int aantalReserveringen() {
        return gastenLijst.getReserveringen().size();
    }

    private class GastenLijst {

        public static final int MAX_AANTAL_GASTEN = 30;
        private Gast[] gasten = new Gast[MAX_AANTAL_GASTEN];
        private MultiValuedMap<LocalDate, Reservering> reserveringen = new HashSetValuedHashMap<>();

        private GastenLijst() {}

        public Gast[] getGasten() {
            return gasten;
        }

        public MultiValuedMap<LocalDate, Reservering> getReserveringen() {
            return reserveringen;
        }

        private void voegReserveringToe(Reservering reservering) {
            reserveringen.put(reservering.getReserveringsDatumEnTijd().toLocalDate(), reservering);
        }

        /**
         * Deze methode controleert of er al een reserving is geboekt op een specifieke datum en tijd
         * @param reserveringsDatumEnTijd
         * @return boolean
         */
        private boolean bestaatReserveringAlOpDatumEnTijd(LocalDateTime reserveringsDatumEnTijd) {
            if (reserveringen.containsKey(reserveringsDatumEnTijd.toLocalDate())) {
                final Collection<Reservering> reserveringenOpDatum = reserveringen.get(reserveringsDatumEnTijd.toLocalDate());
                for(Reservering res : reserveringenOpDatum) {
                    if(res.getReserveringsDatumEnTijd().equals(reserveringsDatumEnTijd)) return true;
                }
            }
            return false;
        }

    }

}
