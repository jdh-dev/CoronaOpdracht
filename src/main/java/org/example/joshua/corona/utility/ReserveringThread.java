package org.example.joshua.corona.utility;

import org.example.joshua.corona.model.ReserveringManager;

import java.util.Random;

public class ReserveringThread extends Thread {

    Random random = new Random();
    private ReserveringManager reserveringManager = ReserveringManager.getInstance();

    @Override
    public void run() {
        int minInterval = 5;
        int maxInterval = 10;
        int interval = random.nextInt(maxInterval - minInterval) + minInterval;

        while (true) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            gastenLijstManager.boekReservering();
        }

    }
}
