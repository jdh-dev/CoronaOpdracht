package org.example.joshua.corona;

import org.example.joshua.corona.model.*;
import org.example.joshua.corona.utility.AdresUtil;
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
        GastenLijstManager gastenLijstManager = new GastenLijstManager();
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);

        Gast gast = new Gast("Joshua", "234567", h1);

        Reservering reservering = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 3, 22, 18, 15), 5);
        System.out.println(reservering);

        assertThat(reservering).isEqualTo(null);
    }

    @Test
    void testReservationWithMoreThanFivePeople() {
        GastenLijstManager gastenLijstManager = new GastenLijstManager();
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);

        Gast gast = new Gast("Joshua", "234567", h1);

        Reservering reservering = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 3, 22, 18, 15), 6);
        System.out.println(reservering);

        assertThat(reservering).isEqualTo(null);
    }

    @Test
    void testReservationsOnTheSameDateAndTime() {
        GastenLijstManager gastenLijstManager = new GastenLijstManager();
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);

        Gast gast = new Gast("Joshua", "234567", h1);

        Reservering r1 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 11, 22, 18, 15), 3);
        Reservering r2 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2020, 11, 22, 18, 15), 2);

        gastenLijstManager.behandelInkomendeReservering(r1);
        gastenLijstManager.behandelInkomendeReservering(r2);

        assertThat(gastenLijstManager.aantalReserveringen()).isEqualTo(2);
    }

    @Test
    void testReservationBeforeNoon() {
        GastenLijstManager gastenLijstManager = new GastenLijstManager();
        Adres a1 = new Adres("Graaf Willemstraat", 1, "2033NJ", "Haarlem");
        Huis h1 = Huis.maakHuis(a1);

        Gast gast = new Gast("Joshua", "234567", h1);

        Reservering r1 = Reservering.maakReservering(gast, ReserveringsType.TELEFONISCH, LocalDateTime.of(2021, 10, 22, 8, 15), 3);
        gastenLijstManager.behandelInkomendeReservering(r1);

        assertThat(gastenLijstManager.aantalReserveringen()).isEqualTo(0);
    }

    @Test
    void testReservationsWithNumberOfGuestsBiggerThanMaximumAllowed() {
        GastenLijstManager gastenLijstManager = new GastenLijstManager();
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

        gastenLijstManager.behandelInkomendeReservering(r1);
        gastenLijstManager.behandelInkomendeReservering(r2);
        gastenLijstManager.behandelInkomendeReservering(r3);
        gastenLijstManager.behandelInkomendeReservering(r4);
        gastenLijstManager.behandelInkomendeReservering(r5);
        gastenLijstManager.behandelInkomendeReservering(r6);
        gastenLijstManager.behandelInkomendeReservering(r7);
        gastenLijstManager.behandelInkomendeReservering(r8);

    }

    @AfterEach
    void reset() {
        AdresUtil.getAdressen().clear();
    }

}
