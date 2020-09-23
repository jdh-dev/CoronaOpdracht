package org.example.joshua.corona.model;

import org.example.joshua.corona.utility.AdresUtil;

public class Huis {

    private int aantalKamers;
    private Adres adres;
    private Persoon[] bewoners;

    public Huis(Adres adres) {
        if (AdresUtil.adresBestaatAl(adres)) {
            System.out.println("Adres bestaat al. Voer een andere adres in");
        } else {
            setAdres(adres);
        }
    }

    public int getAantalKamers() {
        return aantalKamers;
    }

    public void setAantalKamers(int aantalKamers) {
        this.aantalKamers = aantalKamers;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
        AdresUtil.voegNieuwAdresToe(adres);
    }

    public Persoon[] getBewoners() {
        return bewoners;
    }

    public void setBewoners(Persoon[] bewoners) {
        this.bewoners = bewoners;
    }

    @Override
    public String toString() {
        return "Huis{" +
                "aantalKamers=" + aantalKamers +
                ", adres=" + adres +
                ", bewoners=" + bewoners.length +
                '}';
    }


}
