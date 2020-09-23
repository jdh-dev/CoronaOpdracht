package org.example.joshua.corona.model;

public class Huis {

    private int aantalKamers;
    private Adres adres;
    private Persoon[] bewoners;

    public Huis(Adres adres) {
        setAdres(adres);
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
        if (huisMetAdresBestaatAl(adres)) {
            System.out.println("Huis met adres " + adres.toString() + " bestaat al");
        } else {
            this.adres = adres;
        }
    }

    public Persoon[] getBewoners() {
        return bewoners;
    }

    public void setBewoners(Persoon[] bewoners) {
        this.bewoners = bewoners;
    }

    /**
     * Controleert of het adres van het (actieve) object gelijk is aan het adres van het argument
     * @param adres
     * @return boolean
     */
    boolean huisMetAdresBestaatAl(Adres adres) {
        return this.getAdres().equals(adres);
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
