package com.thomasbenard.feedbackloop;

import java.util.Random;

import static com.thomasbenard.feedbackloop.Direction.*;

public class RandomDirectionGenerator implements DirectionGenerator {
    private Random rng = new Random();
    public Direction getNextDirection() {
        int randomNumber = rng.nextInt(DIRECTION_NUMBER);
        if(randomNumber == 0)
            return new Direction(1, true);
        else if(randomNumber == 1)
            return new Direction(0, true);
        else if(randomNumber == 2)
            return new Direction(1, false);
        else
            return new Direction(0, false);
    }
}
