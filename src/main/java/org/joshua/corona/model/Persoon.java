package org.joshua.corona.model;

public class Persoon {

    private String naam;
    private String telefoonNummer;
    private Huis huis;

    public Persoon(String naam, String telefoonNummer, Huis huis) {
        this.naam = naam;
        this.telefoonNummer = telefoonNummer;
        this.huis = huis;
        this.huis.getBewoners().add(this);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public Huis getHuis() {
        return huis;
    }

    public void setHuis(Huis huis) {
        this.huis = huis;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "naam='" + naam + '\'' +
                ", telefoonNummer='" + telefoonNummer + '\'' +
                ", huis=" + huis +
                '}';
    }
}
