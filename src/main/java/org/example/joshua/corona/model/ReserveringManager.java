package org.example.joshua.corona.model;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReserveringManager {

    private static ReserveringManager reserveringManager;
    private GastenLijst gastenLijst = new GastenLijst();
    public static final String DATE_TIME_PATTERN = "dd-MM-yyyy HH:mm";
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final Duration MAX_UREN_PER_RESERVERING = Duration.ofHours(2);
    public static final int MAX_AANTAL_GASTEN = 30;
    private static List<Reservering> reserveringen = new ArrayList<>();

    private ReserveringManager(){}

    public static ReserveringManager getInstance() {
        if (reserveringManager != null) {
            return reserveringManager;
        }
        return new ReserveringManager();
    }

    public void behandelReservering(Gast gast, ReserveringsType reserveringsType,
                                LocalDateTime reserveringsDatumEnTijd, int aantalGasten) {
        if (gast == null) {
            System.out.println("Reservering moet op naam staan van een persoon.");
            return;
        }
        if (reserveringsType == ReserveringsType.AAN_DE_DEUR) {
            reserveringsDatumEnTijd = LocalDateTime.now();
        }
        if ((gastenLijst.aantalGastenGeboektOpEenTijdstip(reserveringsDatumEnTijd) + aantalGasten) > MAX_AANTAL_GASTEN) {
            System.out.println("Kan niet reserveren. Maximum aantal gasten is op dit tijdstip bereikt");
        } else {
            final Reservering reservering = Reservering.maakReservering(gast, reserveringsType, reserveringsDatumEnTijd, aantalGasten);
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

        // De MultiValuedMap kan meerdere waardes bevatten op één Key.
        // Als Key wordt de datum opgegeven van de reservering en onder deze Key kunnen dus meerdere Reservering objecten opgeslagen worden
        private MultiValuedMap<LocalDate, Reservering> reserveringen = new HashSetValuedHashMap<>();

        private GastenLijst() {}

        public MultiValuedMap<LocalDate, Reservering> getReserveringen() {
            return reserveringen;
        }

        private void voegReserveringToe(Reservering reservering) {
            reserveringen.put(reservering.getReserveringsDatumEnTijd().toLocalDate(), reservering);
        }

        /**
         * Deze methode kijkt hoeveel gasten er zijn geboekt op een specfieke tijdstip
         * @param reserveringsDatumEnTijd
         * @return
         */
        private int aantalGastenGeboektOpEenTijdstip(LocalDateTime reserveringsDatumEnTijd){
            int aantalGastenGeboektTijdensReservering = 0;
            if (reserveringen.containsKey(reserveringsDatumEnTijd.toLocalDate())) {
                final Collection<Reservering> reserveringenOpDatum = reserveringen.get(reserveringsDatumEnTijd.toLocalDate());
                for(Reservering bestaandeReservering : reserveringenOpDatum) {
                    if (isBestaandeReserveringGeboektTijdensNieuweReservering(bestaandeReservering.getReserveringsDatumEnTijd(), reserveringsDatumEnTijd)) {
                        aantalGastenGeboektTijdensReservering += bestaandeReservering.getAantalGasten();
                    }
                }
            }
            System.out.println("Aantal gasten geboekt op " + reserveringsDatumEnTijd.format(formatter) + ": " + aantalGastenGeboektTijdensReservering);
            return aantalGastenGeboektTijdensReservering;
        }

        /**
         * Deze methode controleert of een reservering op een bepaalde tijdstip is geboekt
         * @param bestaandeReservering
         * @param nieuwReservering
         * @return
         */
        private boolean isBestaandeReserveringGeboektTijdensNieuweReservering(LocalDateTime bestaandeReservering, LocalDateTime nieuwReservering) {
            return bestaandeReservering.isAfter(nieuwReservering.minus(Duration.ofMinutes(1)))
                    && bestaandeReservering.isBefore(nieuwReservering.plus(Duration.ofMinutes(1)));
        }

    }

}
