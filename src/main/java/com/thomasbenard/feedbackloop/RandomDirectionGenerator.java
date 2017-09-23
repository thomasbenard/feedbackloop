package com.thomasbenard.feedbackloop;

import java.util.Random;

import static com.thomasbenard.feedbackloop.Direction.*;

public class RandomDirectionGenerator implements DirectionGenerator {
    private Random rng = new Random();
    public Direction getNextDirection() {
        int randomNumber = rng.nextInt(DIRECTION_NUMBER);
        if(randomNumber == 0)
            return NORTH;
        else if(randomNumber == 1)
            return EAST;
        else if(randomNumber == 2)
            return SOUTH;
        else
            return WEST;
    }
}
