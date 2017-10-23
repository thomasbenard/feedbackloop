package com.thomasbenard.feedbackloop;

public class Direction {

    public static int DIRECTION_NUMBER = 4;
    public final int dimension;
    public final boolean isForward;

    Direction(int dimension, boolean isForward) {
        this.dimension = dimension;
        this.isForward = isForward;
    }
}
