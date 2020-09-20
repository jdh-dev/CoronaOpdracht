package org.example.joshua.corona.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Huis {

    private static final int MAX_AANTAL_PERSONEN_IN_HUIS_EXCL_BEWONERS = 6;

    private int aantalKamers;
    private Adres adres;
    private Persoon[] bewoners;

    // De reden dat ik een ArrayList gebruik, is omdat je bij een fixed Array altijd het getal terug krijgt van de opgegeven grootte.
    // Dus ook al als je geen enkel persoon toevoegt in de array.
    // Bijvoorbeeld, Persoon[] personen = new Persoon[6]; personen.length, zal dus 6 zijn.
    private List<Persoon> personenInhuis = new ArrayList<>();

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

    public void setBewoners(Persoon[] bewoners) {
        this.bewoners = bewoners;
    }

    public List<Persoon> getPersonenInhuis() {
        return personenInhuis;
    }

    public void setPersonenInhuis(List<Persoon> personenInhuis) {
        this.personenInhuis = personenInhuis;
    }

    /**
     * Deze methode voegt een persoon toe in een huis mits het maximum nog niet is bereikt
     * @param persoon Persoon
     */
    public void voegPersoonToeInHuis(Persoon persoon) {
        if (isMaxAantalBewonersBereikt()) {
            System.out.println("Maximum aantal personen bij " + this.adres.getStraatnaam() + " " + this.adres.getHuisnummer() + " is bereikt");
        } else {
            this.personenInhuis.add(persoon);
            System.out.println(persoon.getNaam() + " is bij " + this.adres.getStraatnaam() + " " + this.adres.getHuisnummer() + " toegevoegd");
        }
    }

    /**
     * Deze methode controleert of het maximum aantal personen in een huis is bereikt
     * @return boolean
     */
    private boolean isMaxAantalBewonersBereikt() {
        return personenInhuis.size() + bewoners.length == bewoners.length + MAX_AANTAL_PERSONEN_IN_HUIS_EXCL_BEWONERS;
    }

    @Override
    public String toString() {
        return "Huis{" +
                "aantalKamers=" + aantalKamers +
                ", adres=" + adres +
                ", bewoners=" + bewoners.length +
                ", personenInhuis=" + personenInhuis.size() +
                '}';
    }
}
