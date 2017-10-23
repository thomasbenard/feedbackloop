package com.thomasbenard.feedbackloop;

import static com.thomasbenard.feedbackloop.Direction.*;

public class TwoNorthOneSouth implements DirectionGenerator{
    int index = 0;
    public Direction getNextDirection() {
        index++;
        if(index % 3 == 0)
            return new Direction(1, false);
        return new Direction(1, true);
    }
}
