package org.example.joshua.corona.model;

import java.util.Arrays;

public class Huis {

    private int aantalKamers;
    private Adres adres;
    private Persoon eindverantwoordelijke;
    private Persoon[] personenInhuis = new Persoon[6];

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

    public Persoon getEindverantwoordelijke() {
        return eindverantwoordelijke;
    }

    public void setEindverantwoordelijke(Persoon eindverantwoordelijke) {
        this.eindverantwoordelijke = eindverantwoordelijke;
    }

    public Persoon[] getPersonenInhuis() {
        return personenInhuis;
    }

    public void setPersonenInhuis(Persoon[] personenInhuis) {
        this.personenInhuis = personenInhuis;
    }

    @Override
    public String toString() {
        return "Huis{" +
                "aantalKamers=" + aantalKamers +
                ", adres=" + adres +
                ", eindverantwoordelijke=" + eindverantwoordelijke +
                ", personenInhuis=" + Arrays.toString(personenInhuis) +
                '}';
    }
}
