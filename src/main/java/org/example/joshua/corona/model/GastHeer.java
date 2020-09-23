package org.example.joshua.corona.model;

public class GastHeer {

    private Huis huis;
    private GastenLijst gastenLijst;

    public GastHeer(Huis huis) {
        this.huis = huis;
        this.gastenLijst = new GastenLijst();
    }

    public Huis getHuis() {
        return huis;
    }

    public void setHuis(Huis huis) {
        this.huis = huis;
    }

    public GastenLijst getGastenLijst() {
        return gastenLijst;
    }

    public void voegOfVerwijderGastInGastenlijst(Persoon persoon) {
        if(gastenLijst.isMaxAantalPersonenBereikt()) {
            gastenLijst.verwijderEersteGastenlijstPlek();
        }
        gastenLijst.voegGastToeAanGastenlijst(persoon);
    }

    private void stuurEerstePersoonWeg() {

    }
}
