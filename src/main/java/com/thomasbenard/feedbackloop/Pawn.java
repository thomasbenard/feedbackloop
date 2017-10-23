package com.thomasbenard.feedbackloop;

import java.util.ArrayList;
import java.util.List;

public class Pawn {
    private Position position;

    public Pawn(Position position) {
        this.position = position;
    }

    public Position move(Direction direction, int distance) {
        position = new Position(computeNewCoordinates(direction, distance));
        return position;
    }

    private List<Integer> computeNewCoordinates(Direction direction, int distance) {
        List<Integer> newCoordinates = new ArrayList<Integer>(position.coordinates);
        newCoordinates.set(direction.dimension, computeChangingCoordinate(direction, distance));
        return newCoordinates;
    }

    private int computeChangingCoordinate(Direction direction, int distance) {
        int movingAxisCoordinate = position.coordinates.get(direction.dimension);
        if(direction.isForward)
            movingAxisCoordinate += distance;
        else
            movingAxisCoordinate -= distance;
        return movingAxisCoordinate;
    }
}
