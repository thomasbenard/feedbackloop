package com.thomasbenard.feedbackloop;

class PositionComparator {

    private Position position;
    private Position target;

    public PositionComparator(Position position, Position target) {
        this.position = position;
        this.target = target;
    }

    public boolean than(Position other) {
        return position.distanceTo(target) <= other.distanceTo(target);
    }

}
