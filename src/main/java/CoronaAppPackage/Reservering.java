package CoronaAppPackage;

import java.time.LocalDateTime;

public class Reservering {

    private String naam;
    private String tel;
    private LocalDateTime datumEnTijdReservering;
    private Integer aantalGasten;
    private Integer reserveringId;
    private LocalDateTime eindTijdReservering;

    public Reservering(Integer reserveringId,
                       String naamReservering,
                       String telefoonnummer,
                       LocalDateTime beginDatumEnTijdReservering,
                       LocalDateTime eindTijdReservering,
                       Integer aantalGasten)
    {
        setReserveringId(reserveringId);
        setNaam(naamReservering);
        setTel(telefoonnummer);
        setDatumEnTijdReservering(beginDatumEnTijdReservering);
        setEindTijdReservering(eindTijdReservering);
        setAantalGasten(aantalGasten);
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setDatumEnTijdReservering(LocalDateTime datumEnTijdReservering) {
        this.datumEnTijdReservering = datumEnTijdReservering;
    }

    public LocalDateTime getDatumEnTijdReservering() {
        return datumEnTijdReservering;
    }

    public Integer getAantalGasten() {
        return aantalGasten;
    }

    public void setAantalGasten(Integer aantalGasten) {
        this.aantalGasten = aantalGasten;
    }

    public void setReserveringId(Integer reserveringId) {
        this.reserveringId = reserveringId;
    }

    public Integer getReserveringId() {
        return reserveringId;
    }

    public void setEindTijdReservering(LocalDateTime eindTijdReservering) {
        this.eindTijdReservering = eindTijdReservering;
    }

    public LocalDateTime getEindTijdReservering() {
        return eindTijdReservering;
    }
}
