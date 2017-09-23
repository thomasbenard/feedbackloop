package com.thomasbenard.feedbackloop;

public class AlwaysSouth implements DirectionGenerator{
    public Direction getNextDirection() {
        return Direction.SOUTH;
    }
}
