package org.example.joshua.corona.utility;

import org.example.joshua.corona.model.Adres;
import org.example.joshua.corona.model.Huis;

import java.util.ArrayList;
import java.util.List;

/**
 * Dit is een utility klasse die o.a. bijhoudt welke adressen zijn aangemaakt.
 */
public class AdresUtil {

    private static List<Adres> adressen = new ArrayList<>();

    public static List<Adres> getAdressen() {
        return adressen;
    }

    /**
     * Deze methode voegt een nieuwe adres toe (en kijkt eerst of het al bestaat. )
     * @param adres Adres
     */
    public static void voegNieuwAdresToe(Adres adres) {
        if (adresBestaatAl(adres)) {
            System.out.println("Adres bestaat al in het systeem");
        } else {
            adressen.add(adres);
        }
    }

    /**
     * Deze methode controleert of het adres al bestaat
     * @param adres van huis
     * @return boolean
     */
    public static boolean adresBestaatAl(Adres adres) {
        return adressen.contains(adres);
    }

    public static void printAlleAdressenUit() {
        for (Adres adres : adressen) {
            System.out.println(adres);
        }
    }
}
