package com.thomasbenard.feedbackloop;

import static com.thomasbenard.feedbackloop.Direction.*;

public class Pawn {
    private Position position;

    public Pawn(Position position) {

        this.position = position;
    }

    public Position move(Direction direction, int distance) {
        if (direction == NORTH)
            position = new Position(position.x, position.y + distance);
        else if (direction == EAST)
            position = new Position(position.x + distance, position.y);
        else if (direction == SOUTH)
            position = new Position(position.x, position.y - distance);
        else
            position = new Position(position.x - distance, position.y);
        return position;
    }
}
