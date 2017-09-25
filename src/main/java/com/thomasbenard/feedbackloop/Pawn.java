package com.thomasbenard.feedbackloop;

import static com.thomasbenard.feedbackloop.Direction.*;

public class Pawn {
    private Position position;

    public Pawn(Position position) {

        this.position = position;
    }

    public Position move(Direction direction, int distance) {
        if (direction == NORTH)
            position = new Position(position.coordinates.get(0), position.coordinates.get(1) + distance);
        else if (direction == EAST)
            position = new Position(position.coordinates.get(0) + distance, position.coordinates.get(1));
        else if (direction == SOUTH)
            position = new Position(position.coordinates.get(0), position.coordinates.get(1) - distance);
        else
            position = new Position(position.coordinates.get(0) - distance, position.coordinates.get(1));
        return position;
    }
}
