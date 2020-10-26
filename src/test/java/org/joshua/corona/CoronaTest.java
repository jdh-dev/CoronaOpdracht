package org.joshua.corona;

import org.joshua.corona.utility.AdresUtil;
import org.joshua.corona.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

public class CoronaTest {

    @Test
    void testIfAddressWithNegativeNumberCanBeCreated() {
        Adres adres = new Adres("Graaf Willemstraat", -1, "2033NJ", "Haarlem");
        assertThat(adres.getHuisnummer()).isEqualTo(0);
    }

    @Test
    void testIfHouseWithAddressAlreadyExist() {
        Adres adres = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        System.out.println("Maak nieuw adres aan met dezelfde waardes");
        Adres adres2 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(adres);
        Huis h2 = Huis.maakHuis(adres);
        AdresUtil.printAlleAdressenUit();
        assertThat(h2).isEqualTo(null);
    }

    @Test
    void testIfHousesWithDifferentAddressesCanBeAdded() {
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Adres a2 = new Adres("Graaf Willemstraat", 2, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);
        Huis h2 = Huis.maakHuis(a2);
        AdresUtil.printAlleAdressenUit();
        assertThat(AdresUtil.getAdressen().size()).isEqualTo(2);
    }

    @Test
    void testIfSameBewonerCanBeAddedInAHouse() {
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);

        Persoon b1 = new Persoon("Joshua", "", h1);
        Persoon b2 = new Persoon("Joshua", "", h1);

        System.out.println(b1);
        assertThat(h1.getBewoners().size()).isEqualTo(1);
    }

    @Test
    void testBookReservationInThePastWithoutAcceptation() {
        ReserveringManager reserveringManager = ReserveringManager.getInstance();
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);

        Gast gast = new Gast("Joshua", "234567", h1);

        Reservering reservering = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 3, 22, 18, 15), 5);
        System.out.println(reservering);

        assertThat(reservering).isEqualTo(null);
    }

    @Test
    void checkTeller() {
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);

        Gast gast = new Gast("Joshua", "234567", h1);

        Reservering r1 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 11, 22, 18, 15), 4);
        Reservering r2 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 11, 22, 18, 15), 4);
        Reservering r3 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 11, 22, 18, 15), 4);
        Reservering r4 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 11, 22, 18, 15), 4);
        Reservering r5 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 11, 22, 18, 15), 4);
        Reservering r6 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 11, 22, 18, 15), 4);
        Reservering r7 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 11, 22, 18, 15), 4);
        Reservering r8 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 11, 22, 18, 15), 4);

        System.out.println(r1.getReserveringTeller());
        System.out.println(r2.getReserveringTeller());
        System.out.println(r3.getReserveringTeller());
        System.out.println(r4.getReserveringTeller());
        System.out.println(r5.getReserveringTeller());
        System.out.println(r6.getReserveringTeller());
        System.out.println(r7.getReserveringTeller());
        System.out.println(r8.getReserveringTeller());
    }

    @Test
    void testReservationWithMoreThanFivePeople() {
        ReserveringManager reserveringManager = ReserveringManager.getInstance();
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);

        Gast gast = new Gast("Joshua", "234567", h1);

        Reservering reservering = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 3, 22, 18, 15), 6);
        System.out.println(reservering);

        assertThat(reservering).isEqualTo(null);
    }

    @Test
    void testReservationsOnTheSameDateAndTime() {
        ReserveringManager reserveringManager = ReserveringManager.getInstance();
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);

        Gast gast = new Gast("Joshua", "234567", h1);

        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.of(2020, 11, 22, 18, 15), 3);
        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.of(2020, 11, 22, 18, 15), 2);

        assertThat(reserveringManager.aantalReserveringen()).isEqualTo(2);
    }

    @Test
    void testReservationBeforeNoon() {
        ReserveringManager reserveringManager = ReserveringManager.getInstance();
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);

        Gast gast = new Gast("Joshua", "234567", h1);

        Reservering r1 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2021, 10, 22, 8, 15), 3);
        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.now(), 4);

        assertThat(reserveringManager.aantalReserveringen()).isEqualTo(0);
    }

    @Test
    void testReservationsWithNumberOfGuestsBiggerThanMaximumAllowed() {
        ReserveringManager reserveringManager = ReserveringManager.getInstance();
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);
        Gast gast = new Gast("Joshua", "234567", h1);

        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.now(), 4);
        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.now(), 4);
        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.now(), 4);
        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.now(), 4);
        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.now(), 4);
        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.now(), 4);
        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.now(), 4);
        reserveringManager.behandelReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.now(), 4);

        assertThat(reserveringManager.aantalReserveringen()).isLessThan(30);
    }

    @Test
    void testReservationBookedAfterNinePMShouldNotBePossible() {
        ReserveringManager reserveringManager = ReserveringManager.getInstance();
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);
        Gast gast = new Gast("Joshua", "234567", h1);

        Reservering reservering = Reservering.maakReservering(gast, ReserveringsType.AAN_DE_DEUR, LocalDateTime.of(2020, 12, 20, 22, 0), 3);

        assertThat(reservering).isEqualTo(null);
    }

    @AfterEach
    void reset() {
        AdresUtil.getAdressen().clear();
    }

}
