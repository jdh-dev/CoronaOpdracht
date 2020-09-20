package org.example.joshua.corona;

import org.example.joshua.corona.model.Adres;
import org.example.joshua.corona.model.Huis;
import org.example.joshua.corona.model.Persoon;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CoronaTest {

    @Test
    void testOfMaximumAantalPersonenIsBereikt() {
        Adres adres = new Adres("John F. Kennedylaan", 8, "7314PS", "Apeldoorn");
        Huis huis = new Huis(adres);
        Persoon bewoner = new Persoon("Joshua");

        huis.setBewoners(new Persoon[] {bewoner});
        huis.voegPersoonToeInHuis(new Persoon("Mike"));
        huis.voegPersoonToeInHuis(new Persoon("Sjoerd"));
        huis.voegPersoonToeInHuis(new Persoon("Sam"));
        huis.voegPersoonToeInHuis(new Persoon("Rein"));
        huis.voegPersoonToeInHuis(new Persoon("Cihangir"));
        huis.voegPersoonToeInHuis(new Persoon("Madjid"));
        // Voeg nieuwe persoon toe na maximum
        huis.voegPersoonToeInHuis(new Persoon("Joris"));

        assertThat(huis.getPersonenInhuis().size() == Huis.MAX_AANTAL_PERSONEN_IN_HUIS_EXCL_BEWONERS);
    }
}
