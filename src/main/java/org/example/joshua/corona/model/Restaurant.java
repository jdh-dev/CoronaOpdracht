package org.example.joshua.corona.model;

import org.example.joshua.corona.utility.ReserveringThread;

/**
 * Singleton klasse van Restaurant
 */
public class Restaurant {

    private static Restaurant restaurant;
    private static final int MAX_AANTAL_TAFELS = 16;
    private Tafel[] tafels = new Tafel[MAX_AANTAL_TAFELS];
    private ReserveringManager reserveringManager = ReserveringManager.getInstance();

    private Restaurant() {
        initRestaurant();
        System.out.println("Restaurant is open for business!");
    }

    /**
     * Singleton methode waarbij er alleen maar 1 instantie van deze klasse gemaakt kan worden
     * @return
     */
    public static Restaurant getInstance() {
        if (restaurant == null) {
            restaurant = new Restaurant();
        }
        return restaurant;
    }

    public void openForBusiness() {
        ReserveringThread reserveringThread = new ReserveringThread();
        reserveringThread.start();



    }

    public Tafel[] getTafels() {
        return tafels;
    }

    /**
     * Deze methode initialiseert en creërt het aantal tafels in het restaurant
     */
    private void initRestaurant() {
        System.out.println("Het restaurant wordt gereedgemaakt voor de klanten");
        for (int i = 0; i < MAX_AANTAL_TAFELS; i++) {
            this.tafels[i] = new Tafel(i);
        }
    }

    public void printTafels() {
        for(Tafel tafel : getTafels()) {
            System.out.println(tafel);
        }
    }

    /**
     * Private klasse waar alleen de klasse Restaurant van af weet
     */
    private class Tafel {

        public Tafel(int tafelNummer) {
            this.tafelNummer = tafelNummer;
        }

        private int tafelNummer;

        public int getTafelNummer() {
            return tafelNummer;
        }

        public void setTafelNummer(int tafelNummer) {
            this.tafelNummer = tafelNummer;
        }

        @Override
        public String toString() {
            return "Tafel{" +
                    "tafelNummer=" + tafelNummer +
                    '}';
        }
    }
}
