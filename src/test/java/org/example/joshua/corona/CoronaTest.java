package org.example.joshua.corona;

import org.example.joshua.corona.model.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CoronaTest {

    @Test
    void testOfMaximumAantalPersonenIsBereikt() {
        Adres adres = new Adres("John F. Kennedylaan", 8, "7314PS", "Apeldoorn");
        Huis huis = new Huis(adres);
        Persoon bewoner = new Persoon("Joshua");

//        huis.setBewoners(new Persoon[] {bewoner});
//        huis.voegPersoonToeInHuis(new Persoon("Mike"));
//        huis.voegPersoonToeInHuis(new Persoon("Sjoerd"));
//        huis.voegPersoonToeInHuis(new Persoon("Sam"));
//        huis.voegPersoonToeInHuis(new Persoon("Rein"));
//        huis.voegPersoonToeInHuis(new Persoon("Cihangir"));
//        huis.voegPersoonToeInHuis(new Persoon("Madjid"));
//        // Voeg nieuwe persoon toe na maximum
//        huis.voegPersoonToeInHuis(new Persoon("Joris"));
        //test of aantal personen nog steeds gelijk is aan max
//        assertThat(huis.getGastenInhuis().length == GastenLijst.MAX_AANTAL_PERSONEN_IN_HUIS_EXCL_BEWONERS);
    }

    @Test
    void testGastenLijst() {
        Adres adres = new Adres("John F. Kennedylaan", 8, "7314PS", "Apeldoorn");
        GastHeer gastHeer = new GastHeer(new Huis(adres));

        gastHeer.voegOfVerwijderGastInGastenlijst(new Persoon("Joshua"));
        gastHeer.voegOfVerwijderGastInGastenlijst(new Persoon("sjdnfkj"));
        gastHeer.voegOfVerwijderGastInGastenlijst(new Persoon("kjfnkjdsf"));
        gastHeer.voegOfVerwijderGastInGastenlijst(new Persoon("Joskjndkndhua"));
        gastHeer.voegOfVerwijderGastInGastenlijst(new Persoon("kjsa"));
        gastHeer.voegOfVerwijderGastInGastenlijst(new Persoon("ksandk"));
        gastHeer.voegOfVerwijderGastInGastenlijst(new Persoon("Frank"));
        gastHeer.voegOfVerwijderGastInGastenlijst(new Persoon("Bert"));
        gastHeer.voegOfVerwijderGastInGastenlijst(new Persoon("Ernie"));
        for (Persoon persoon : gastHeer.getGastenLijst().getGastenInhuis()) {
            System.out.println(persoon);
        }
    }



}
