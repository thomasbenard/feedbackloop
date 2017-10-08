package com.thomasbenard.feedbackloop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

public class Position {
    public final List<Integer> coordinates;

    public Position(Integer... coordinates) {
        this.coordinates = new ArrayList(Arrays.asList(coordinates));
    }

    public Position(List<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return coordinates != null ? coordinates.equals(position.coordinates) : position.coordinates == null;
    }

    @Override
    public int hashCode() {
        return coordinates != null ? coordinates.hashCode() : 0;
    }

    public PositionComparator isCloserTo(Position target) {
        return new PositionComparator(this, target);
    }

    double distanceTo(Position origin) {
        int norm = 0;
        for (int i = 0; i < coordinates.size(); ++i)
            norm += pow(origin.coordinates.get(i) - coordinates.get(i), 2);
        return sqrt(norm);
    }
}
