package com.pokemon.pokemon_api.util;

import java.util.Random;

public class Utils {


    public static Integer generateRandomIDWithinBounds() {
        Random random = new Random();
        return random.ints(1, 51).findFirst().orElseThrow();
    }
}
