package org.joshua.corona;

import org.joshua.corona.model.Restaurant;

public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();

        restaurant.openForBusiness();
    }
}
