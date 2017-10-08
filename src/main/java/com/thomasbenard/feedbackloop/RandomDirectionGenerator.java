package com.thomasbenard.feedbackloop;

import java.util.Random;

public class RandomDirectionGenerator implements DirectionGenerator {

    public final int dimensionNumber;
    private Random rng = new Random();

    public RandomDirectionGenerator(int dimensionNumber) {
        this.dimensionNumber = dimensionNumber;
    }

    public Direction getNextDirection() {
        return new Direction(rng.nextInt(dimensionNumber), rng.nextBoolean());
    }
}
