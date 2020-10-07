package CoronaAppPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class datumEnTijdMethodes {

    public static Date datumEnTijd(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Geef datum: dd-mm-jjjj");

        String date = scanner.next();

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date2=null;
        try {
            date2 = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date2);

        return date2;
    }

    public static LocalDateTime vraagNaarDatumEnTijdVanReservering(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Op welke datum wilt u een reservering plaatsen? dd-mm-jjjj");
        String reserveringsdatum = scanner.next();
        System.out.println("Op welk tijdstip wilt u een reservering plaatsen? uu:mm");
        String reserveringstijd = scanner.next();

        String datumEnTijdVanReservingString = reserveringsdatum + " " + reserveringstijd;

        System.out.println(datumEnTijdVanReservingString);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime reserveringsDatumEnTijd = LocalDateTime.parse(datumEnTijdVanReservingString, formatter);

        return reserveringsDatumEnTijd;
    }

    public static void overzichtVanIngevoerdeGegevensVoorDeGebruikerTerControle(Reservering reservering) {
        System.out.println();
        System.out.println("Controleer de gegevens:");
        System.out.println("Naam: " + reservering.getNaam());
        System.out.println("Telefoonnummer: " + reservering.getTel());
        System.out.println("Op: " + reservering.getDatumEnTijdReservering().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("Om: " + reservering.getDatumEnTijdReservering().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println("U komt in totaal met " + reservering.getAantalGasten() + " mensen.");
    }

    public static boolean controleerDatumEnTijdVanReservering(Reservering eenReservering, Reservering nieuweReservering) {

        if (nieuweReserveringBeginTijdGelijkIsAanReserveringArrayBeginTijd(eenReservering, nieuweReservering)) {
            return false;
        }
        else if (nieuweReserveringBeginTijdNaReserveringArrayBeginTijd(eenReservering, nieuweReservering)) {
            return !nieuweReserveringBeginTijdVoorReserveringArrayEindTijd(eenReservering, nieuweReservering);
        }
        else if(nieuweReserveringBegintVoorBestaandeReservering(eenReservering, nieuweReservering)){
            return !nieuweReserveringEindigtTijdensTijdvakBestaandeReservering(eenReservering, nieuweReservering);
        }
        System.out.println("er is iets geks aan de hand");
        return false;
    }

    static boolean nieuweReserveringBeginTijdGelijkIsAanReserveringArrayBeginTijd(Reservering reserveringArray, Reservering reservering) {
        return reservering.getDatumEnTijdReservering().isEqual(reserveringArray.getDatumEnTijdReservering());
    }

    static boolean nieuweReserveringBeginTijdNaReserveringArrayBeginTijd(Reservering reserveringArray, Reservering reservering) {
        return reservering.getDatumEnTijdReservering().isAfter(reserveringArray.getDatumEnTijdReservering());
    }

    static boolean nieuweReserveringBeginTijdVoorReserveringArrayEindTijd(Reservering reserveringArray, Reservering reservering) {
        return reservering.getDatumEnTijdReservering().isBefore(reserveringArray.getEindTijdReservering());
    }

    static boolean nieuweReserveringBegintVoorBestaandeReservering(Reservering reserveringArray, Reservering reservering) {
        return reservering.getDatumEnTijdReservering().isBefore(reserveringArray.getDatumEnTijdReservering());
    }

    static boolean nieuweReserveringEindigtTijdensTijdvakBestaandeReservering(Reservering reserveringArray, Reservering reservering) {
        return reservering.getEindTijdReservering().isAfter(reserveringArray.getDatumEnTijdReservering());
    }

    public static Reservering maakEenNieuweReservering(Integer beginUren,Integer beginMinuten,Integer eindUren, Integer eindMinuten) {

        return new Reservering(
                1,
                "Barbara",
                "0615487989",
                /*BeginTijd*/LocalDateTime.of(1998,9,11,beginUren,beginMinuten),
                /*EindTijd*/LocalDateTime.of(1998,9,11,eindUren,eindMinuten),
                10);
    }




}
