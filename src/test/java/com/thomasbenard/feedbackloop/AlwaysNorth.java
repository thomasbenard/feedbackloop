package com.thomasbenard.feedbackloop;

public class AlwaysNorth implements DirectionGenerator {
    public Direction getNextDirection() {
        return new Direction(1, true);
    }
}
