package com.thomasbenard.feedbackloop;

public enum Direction {
    EAST(0, true),
    SOUTH(1, false),
    WEST(0, false),
    NORTH(1, true);

    public static int DIRECTION_NUMBER = 4;
    public final int dimension;
    public final boolean isForward;

    Direction(int dimension, boolean isForward) {
        this.dimension = dimension;
        this.isForward = isForward;
    }
}
