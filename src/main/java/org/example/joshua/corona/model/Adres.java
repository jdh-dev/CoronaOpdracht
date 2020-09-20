package org.example.joshua.corona.model;

public class Adres {

    private String straatnaam;
    private int huisnummer;
    private String postcode;
    private String woonplaats;

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
        this.huisnummer = huisnummer;
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
    public String toString() {
        return "Adres{" +
                "straatnaam='" + straatnaam + '\'' +
                ", huisnummer=" + huisnummer +
                ", postcode='" + postcode + '\'' +
                ", woonplaats='" + woonplaats + '\'' +
                '}';
    }
}
