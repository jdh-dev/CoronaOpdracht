package org.example.joshua.corona.model;

public class GastenLijst {

    public static final int MAX_AANTAL_PERSONEN_IN_HUIS_EXCL_BEWONERS = 6;
    private Persoon[] gastenInhuis = new Persoon[MAX_AANTAL_PERSONEN_IN_HUIS_EXCL_BEWONERS];
    private int gastenTeller;

    public GastenLijst() { }

    public Persoon[] getGastenInhuis() {
        return gastenInhuis;
    }

    public void verwijderEersteGastenlijstPlek() {
        gastenInhuis[0] = null;
        gastenTeller--;
        plaatsGastenPlekVooruit(0);
    }

    private void plaatsGastenPlekVooruit(int index) {
        if (index < gastenInhuis.length -1) {
            if (gastenInhuis[index] == null) {
                gastenInhuis[index] = gastenInhuis[index + 1];
                gastenInhuis[index + 1] = null;
            }
            plaatsGastenPlekVooruit(++index);
        }
    }

    public void voegGastToeAanGastenlijst(Persoon persoon) {
        gastenInhuis[zoekPlekInGastenlijst()] = persoon;
        gastenTeller++;
    }

    /**
     *
     * @return
     */
    private int zoekPlekInGastenlijst() {
        int index = 0;
        for (int i = 0; i < gastenInhuis.length; i++) {
            if (gastenInhuis[i] == null & !(gastenInhuis[i] instanceof Persoon)) {
                index = i;
                break;
            }
        }
        return index;
    }



    /**
     * Deze methode controleert of het maximum aantal personen in een huis is bereikt
     * @return boolean
     */
    boolean isMaxAantalPersonenBereikt() {
        return gastenTeller == MAX_AANTAL_PERSONEN_IN_HUIS_EXCL_BEWONERS;
    }


}
