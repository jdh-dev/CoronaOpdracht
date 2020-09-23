package org.example.joshua.corona.model;

import org.example.joshua.corona.utility.AdresUtil;

import java.util.Objects;

public class Adres {

    private String straatnaam;
    private int huisnummer;
    private String postcode;
    private String woonplaats;

    public Adres(String straatnaam, int huisnummer, String postcode, String woonplaats) {
        setStraatnaam(straatnaam);
        setHuisnummer(huisnummer);
        setPostcode(postcode);
        setWoonplaats(woonplaats);
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        if (huisnummer <= 0) {
            System.out.println("Geen geldige invoer. Kies een huisnummer dat groter is dan 0");
        } else {
            this.huisnummer = huisnummer;
        }
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adres adres = (Adres) o;
        return getHuisnummer() == adres.getHuisnummer() &&
                getStraatnaam().equals(adres.getStraatnaam()) &&
                getPostcode().equals(adres.getPostcode()) &&
                getWoonplaats().equals(adres.getWoonplaats());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStraatnaam(), getHuisnummer(), getPostcode(), getWoonplaats());
    }

    @Override
    public String toString() {
        return "Adres{" +
                "straatnaam='" + straatnaam + '\'' +
                ", huisnummer=" + huisnummer +
                ", postcode='" + postcode + '\'' +
                ", woonplaats='" + woonplaats + '\'' +
                '}';
    }
}
