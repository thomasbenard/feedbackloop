package com.thomasbenard.feedbackloop;

import static java.lang.Math.*;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public PositionComparator isCloserTo(Position target) {
        return new PositionComparator(this, target);
    }

    double distanceTo(Position origin) {
        return sqrt(pow(origin.x - x, 2) + pow(origin.y - y, 2));
    }
}
