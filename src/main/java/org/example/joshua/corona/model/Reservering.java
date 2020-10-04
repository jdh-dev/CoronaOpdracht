package org.example.joshua.corona.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class Reservering {

    private Gast aanvrager;
    private ReserveringsType reserveringsType;
    private String reserveringsNummer;
    private static int reserveringTeller;
    private LocalDateTime datumVanReservering;
    private LocalDateTime reserveringsDatumEnTijd;
    private int aantalGasten;
    private boolean geaccepteerd;
    public static final Duration MAX_UREN_PER_RESERVERING = Duration.ofMinutes(2);
    private static final int MAX_PERSONEN_BIJ_RESERVERING = 4;


    private Reservering(Gast aanvrager, ReserveringsType reserveringsType, LocalDateTime reserveringsDatumEnTijd,
                       int aantalGasten) {
        setAanvrager(aanvrager);
        aanvrager.getReserveringen().add(this);
        setReserveringsType(reserveringsType);
        this.reserveringsNummer = maakReserveringsNummerAan();
        this.datumVanReservering = LocalDateTime.now();
        setReserveringsDatumEnTijd(reserveringsDatumEnTijd);
        setAantalGasten(aantalGasten);
        this.geaccepteerd = false;
    }

    /**
     * Maak een nieuwe reservering aan
     * @param gast
     * @param reserveringsType
     * @param reserveringsDatumEnTijd
     * @param aantalGasten
     * @return
     */
    public static Reservering maakReservering(Gast gast, ReserveringsType reserveringsType, LocalDateTime reserveringsDatumEnTijd, int aantalGasten) {
        if(reserveringsDatumEnTijd.isBefore(LocalDateTime.now()) || reserveringsDatumEnTijd.toLocalTime().isBefore(LocalTime.NOON)) {
            System.out.println("Kan geen reserveringen maken die eerder dan vandaag plaatsvinden of op dagen voor 12:00.");
            return null;
        }
        if(aantalGasten > MAX_PERSONEN_BIJ_RESERVERING) {
            System.out.println("Kan niet meer dan 5 personen boeken voor een reservering");
            return null;
        }
        return new Reservering(gast, reserveringsType, reserveringsDatumEnTijd, aantalGasten);

    }

    public Gast getAanvrager() {
        return aanvrager;
    }

    public void setAanvrager(Gast aanvrager) {
        this.aanvrager = aanvrager;
    }

    public ReserveringsType getReserveringsType() {
        return reserveringsType;
    }

    public void setReserveringsType(ReserveringsType reserveringsType) {
        this.reserveringsType = reserveringsType;
    }

    public String getReserveringsNummer() {
        return reserveringsNummer;
    }

    public void setReserveringsNummer(String reserveringsNummer) {
        this.reserveringsNummer = reserveringsNummer;
    }

    public LocalDateTime getReserveringsDatumEnTijd() {
        return reserveringsDatumEnTijd;
    }

    public void setReserveringsDatumEnTijd(LocalDateTime reserveringsDatumEnTijd) {
        this.reserveringsDatumEnTijd = reserveringsDatumEnTijd;
    }

    public int getAantalGasten() {
        return aantalGasten;
    }

    public void setAantalGasten(int aantalGasten) {
        this.aantalGasten = aantalGasten;
    }

    public LocalDateTime getDatumVanReservering() {
        return datumVanReservering;
    }

    public boolean isGeaccepteerd() {
        return geaccepteerd;
    }

    public void setGeaccepteerd(boolean geaccepteerd) {
        this.geaccepteerd = geaccepteerd;
    }

    @Override
    public String toString() {
        return "Reservering{" +
                ", reserveringsType=" + reserveringsType +
                ", reserveringsNummer='" + reserveringsNummer + '\'' +
                ", datumVanReservering=" + datumVanReservering +
                ", reserveringsDatumEnTijd=" + reserveringsDatumEnTijd +
                ", aantalGasten=" + aantalGasten +
                ", geaccepteerd=" + geaccepteerd +
                '}';
    }

    /**
     * Deze methode maakt een uniek reserveringsnummer aan
     * @return
     */
    private String maakReserveringsNummerAan() {
        return "RES" + reserveringTeller++;
    }

}