package CoronaPackage;

import CoronaAppPackage.Reservering;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.Scanner;
import static CoronaAppPackage.datumEnTijdMethodes.*;
import static CoronaAppPackage.tafelMethodes.tafelsOnbeschikbaarStellenNaReserveringOpTijden;
import static org.assertj.core.api.Assertions.assertThat;


public class CoronaAppTests {

    @Test
    void MakeAReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welkom, u kunt hier een reservering maken.");
        System.out.println("Op welke naam mag de reservering komen te staan?");
        String naamReservering = scanner.next();

        System.out.println("Wat is uw telefoonnummer?");
        String telefoonnummer = scanner.next();

        System.out.println("Met hoeveel komt u totaal?");
        Integer aantalGasten = scanner.nextInt();

        LocalDateTime reserveringsDatumEnTijd = vraagNaarDatumEnTijdVanReservering();

        Reservering reservering = new Reservering(1, naamReservering, telefoonnummer, reserveringsDatumEnTijd, null, aantalGasten);

        overzichtVanIngevoerdeGegevensVoorDeGebruikerTerControle(reservering);

    }

    @Test
    void nieuweReserveringstijdIsGelijkAanBestaandeReserveringstijd() {
        //Hierbij is slechts één reservering mogelijk
        //Reserveringstijden zijn in beide gevallen 11-09-1998 om 20:30

        Reservering eenReservering = maakEenNieuweReservering(20, 30, 21, 0);
        Reservering nieuweReservering =  maakEenNieuweReservering(20,30,22,0);
        if (controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)) {
            System.out.println("Uw reservering staat genoteerd!");
        } else System.out.println("Uw reservering is helaas niet mogelijk...");

        assertThat(controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)).isFalse();
    }

    @Test
    void nieuweReserveringsBeginTijdZitInHetTijdsvakVanEenBestaandeReservering() {
        //Hierbij is slechts één reservering tegelijk mogelijk
        Reservering eenReservering = maakEenNieuweReservering(20, 30, 21, 0);
        Reservering nieuweReservering =  maakEenNieuweReservering(20,45,20,55);

        if (controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)) {
            System.out.println("Uw reservering staat genoteerd!");
        } else System.out.println("Uw reservering is helaas niet mogelijk...");

        assertThat(controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)).isFalse();
    }

    @Test
    void nieuweReserveringEindtTijdLigtBinnenTijdvakBestaandeReservering() {
        //Hierbij is slechts één reservering tegelijk mogelijk
        Reservering eenReservering = maakEenNieuweReservering(20, 30, 21, 0);
        Reservering nieuweReservering =  maakEenNieuweReservering(20,0,20,45);

        if (controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)) {
            System.out.println("Uw reservering staat genoteerd!");
        } else System.out.println("Uw reservering is helaas niet mogelijk...");

        assertThat(controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)).isFalse();
    }

    @Test
    void nieuweReserveringBegintNaBeginTijdBestaandeReserveringEnEindigtDaarOokVoor() {
        //Hierbij is slechts één reservering tegelijk mogelijk
        Reservering eenReservering = maakEenNieuweReservering(20, 30, 21, 0);
        Reservering nieuweReservering =  maakEenNieuweReservering(20,35,20,55);

        if (controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)) {
            System.out.println("Uw reservering staat genoteerd!");
        } else System.out.println("Uw reservering is helaas niet mogelijk...");

        assertThat(controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)).isFalse();
    }

    @Test
    void nieuweReserveringBegintVoorBeginTijdBestaandeReserveringEnEindigtExactWanneerDeAnderBegint() {
        //Hierbij is slechts één reservering tegelijk mogelijk
        Reservering eenReservering = maakEenNieuweReservering(20, 30, 21, 0);
        Reservering nieuweReservering = maakEenNieuweReservering(20, 0, 20, 30);

//        if (controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)) {
//            System.out.println("Uw reservering staat genoteerd!");
//        } else System.out.println("Uw reservering is helaas niet mogelijk...");

        assertThat(controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)).isTrue();
    }

    @Test
    void nieuweReserveringBegintNaEindTijdBestaandeReservering() {
        //Hierbij is slechts één reservering tegelijk mogelijk
        Reservering eenReservering = maakEenNieuweReservering(20, 30, 21, 0);
        Reservering nieuweReservering = maakEenNieuweReservering(22, 0, 23, 0);

        if (controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)) {
            System.out.println("Uw reservering staat genoteerd!");
        } else System.out.println("Uw reservering is helaas niet mogelijk...");

        assertThat(controleerDatumEnTijdVanReservering(eenReservering, nieuweReservering)).isTrue();
    }

    @Test
    void aantalTafelsWordenBepaaldEnEenReserveringReduceertDeHoeveelheid() {
        int aantalTafels = 30;

        Reservering reservering = new Reservering(1, "Evan","0634380726", LocalDateTime.of(2020,1,20,20,30), LocalDateTime.of(2020,1,20,20,30), 4);

        aantalTafels = aantalTafels - (2 * reservering.getAantalGasten());

        System.out.println("Er zijn " + aantalTafels + " tafels beschikbaar");

    }

    @Test
    void aantalTafelsOverNaEenReserveringMetBeginTijdVoorHuidigeTijdEnEindTijdNaHuidigeTijd() {
        //huidige fictieve tijd is 20:30
        int aantalTafels = 30;

        Reservering eenReservering = maakEenNieuweReservering(20, 0, 21, 0);

        aantalTafels = aantalTafels - tafelsOnbeschikbaarStellenNaReserveringOpTijden(eenReservering);

        System.out.println("aantal tafels op het moment beschikbaar: " + aantalTafels);

        assertThat(aantalTafels).isEqualTo(10);
    }

    @Test
    void aantalTafelsMetReserveringOpExactDezelfdeBeginTijd() {
        //huidige fictieve tijd is 20:30
        int aantalTafels = 30;

        Reservering eenReservering = maakEenNieuweReservering(20,30,21,0);

        aantalTafels = aantalTafels - tafelsOnbeschikbaarStellenNaReserveringOpTijden(eenReservering);

        System.out.println("aantal tafels op het moment beschikbaar: " + aantalTafels);

        assertThat(aantalTafels).isEqualTo(10);
    }

    @Test
    void aantalTafelsWaarbijDeBeginTijdVanNieuweReserveringInTijdsvakVanBestaandeReserveringValt() {
        //huidige fictieve tijd is 20:30
        int aantalTafels = 30;

        Reservering eenReservering = maakEenNieuweReservering(20,30,21,0);

        aantalTafels = aantalTafels - tafelsOnbeschikbaarStellenNaReserveringOpTijden(eenReservering);

        System.out.println("aantal tafels op het moment beschikbaar: " + aantalTafels);

        assertThat(aantalTafels).isEqualTo(10);
    }
}