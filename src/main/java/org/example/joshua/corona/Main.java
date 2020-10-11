package org.example.joshua.corona;

import org.example.joshua.corona.model.Restaurant;

public class Main {

    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();

        restaurant.openForBusiness();
    }
}
