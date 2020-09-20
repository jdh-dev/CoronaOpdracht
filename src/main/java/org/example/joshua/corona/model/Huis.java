package org.example.joshua.corona.model;

import java.util.Arrays;

public class Huis {

    private static final int MAX_AANTAL_PERSONEN_IN_HUIS_EXCL_BEWONERS = 6;

    private int aantalKamers;
    private Adres adres;
    private Persoon[] bewoners;
    private Persoon[] personenInhuis;

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
    }

    public Persoon[] getBewoners() {
        return bewoners;
    }

    public void setBewoner(Persoon[] bewoners) {
        this.bewoners = bewoners;
    }

    public Persoon[] getPersonenInhuis() {
        return personenInhuis;
    }

    public void setPersonenInhuis(Persoon[] personenInhuis) {
        this.personenInhuis = personenInhuis;
    }

    /**
     * Deze methode controleert of het maximum aantal personen in een huis is bereikt
     * @return boolean
     */
    public boolean isMaxAantalBewonersBereikt() {
        return personenInhuis.length + bewoners.length == bewoners.length + MAX_AANTAL_PERSONEN_IN_HUIS_EXCL_BEWONERS;
    }

    @Override
    public String toString() {
        return "Huis{" +
                "aantalKamers=" + aantalKamers +
                ", adres=" + adres +
                ", bewoners=" + bewoners +
                ", personenInhuis=" + Arrays.toString(personenInhuis) +
                '}';
    }
}
