package CoronaAppPackage;

import java.time.LocalDateTime;

public class tafelMethodes {

    public static int tafelsOnbeschikbaarStellenNaReserveringOpTijden(Reservering reserveringen) {

        LocalDateTime fictiefHuidigeTijd = LocalDateTime.of(1998,9,11,20,30);

        if (reserveringen.getDatumEnTijdReservering().isEqual(fictiefHuidigeTijd)) {

            if (reserveringen.getEindTijdReservering().isAfter(fictiefHuidigeTijd)){
                return (2 * reserveringen.getAantalGasten());
            }
        }

        if (reserveringen.getDatumEnTijdReservering().isBefore(fictiefHuidigeTijd)) {

            if(reserveringen.getEindTijdReservering().isAfter(fictiefHuidigeTijd)) {
                return (2 * reserveringen.getAantalGasten());
            }
        }

        return 0;
    }

}
