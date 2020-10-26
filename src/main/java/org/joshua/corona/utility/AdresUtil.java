package org.joshua.corona.utility;

import org.joshua.corona.model.Adres;

import java.util.*;

/**
 * Dit is een utility klasse die o.a. bijhoudt welke adressen zijn aangemaakt.
 */
public class AdresUtil {

    private static Set<Adres> adressen = new HashSet<>();

    public static Set<Adres> getAdressen() {
        return adressen;
    }

    /**
     * Deze methode voegt een nieuwe adres toe (en kijkt eerst of het al bestaat. )
     * @param adres Adres
     */
    public static void voegNieuwAdresToe(Adres adres) {
        if (adresBestaatAl(adres.getStraatnaam(), adres.getHuisnummer(), adres.getPostcode(), adres.getWoonplaats())) {
            System.out.println("Adres bestaat al in het systeem");
        } else {
            adressen.add(adres);
        }
    }

    /**
     * Deze methode instantieert een Huis object mits het adres al niet bestaat
     * @param straatnaam
     * @param huisnummer
     * @param postcode
     * @param woonplaats
     * @return
     */
    public static boolean adresBestaatAl(String straatnaam, int huisnummer, String postcode, String woonplaats) {
        for (Adres adres : adressen) {
            if (adres.getHuisnummer() == huisnummer &&
                    adres.getStraatnaam().equals(straatnaam) &&
                    adres.getPostcode().equals(postcode) &&
                    adres.getWoonplaats().equals(woonplaats)){
                return true;
            }
        }
        return false;
    }

    public static void printAlleAdressenUit() {
        for (Adres adres : adressen) {
            System.out.println(adres);
        }
    }
}
