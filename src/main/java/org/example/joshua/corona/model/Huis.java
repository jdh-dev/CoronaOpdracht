package org.example.joshua.corona.model;

import org.example.joshua.corona.utility.AdresUtil;

import java.util.HashSet;
import java.util.Set;

public class Huis {

    private Adres adres;
    private Set<Persoon> bewoners = new HashSet<>();

    private Huis(Adres adres) {
        this.adres = adres;
        this.adres.setHuis(this);
        AdresUtil.voegNieuwAdresToe(adres);
    }

    /**
     * Factory methode die een Huis object instantieert mits het adres nog niet bestaat
     * @param adres
     * @return
     */
    public static Huis maakHuis(Adres adres) {
        if (adres == null
                || adres.getHuis() != null
                || AdresUtil.adresBestaatAl(adres.getStraatnaam(), adres.getHuisnummer(), adres.getPostcode(), adres.getWoonplaats())) {
            System.out.println("Adres is leeg of adres behoort al toe aan een ander huis. Voer een andere adres in");
            return null;
        } else {
            return new Huis(adres);
        }
    }

    public Adres getAdres() {
        return adres;
    }

    public Set<Persoon> getBewoners() {
        return bewoners;
    }

    @Override
    public String toString() {
        return "Huis{" +
                ", adres=" + adres +
                ", bewoners=" + bewoners.size() +
                '}';
    }


}
