package com.thomasbenard.feedbackloop;

public class AlwaysNorth implements DirectionGenerator {
    public Direction getNextDirection() {
        return Direction.NORTH;
    }
}
