package com.thomasbenard.feedbackloop;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static com.thomasbenard.feedbackloop.Direction.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PawnTest {

    private Position initialPosition;
    private Direction direction;
    private int distance;
    private final Position endPosition;

    public PawnTest(Direction direction, int distance, final Position endPosition) {
        this.direction = direction;
        this.distance = distance;
        this.endPosition = endPosition;
    }

    @Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(
                new Object[]{NORTH, 1, new Position(0, 1)},
                new Object[]{NORTH, 10, new Position(0, 10)},
                new Object[]{EAST, 1, new Position(1, 0)},
                new Object[]{EAST, 10, new Position(10, 0)},
                new Object[]{SOUTH, 10, new Position(0, -10)},
                new Object[]{WEST, 10, new Position(-10, 0)}
        );
    }

    @Before
    public void setUp() throws Exception {
        initialPosition = new Position(0,0);
    }

    @Test
    public void move_test() {
        Pawn pawn = new Pawn(initialPosition);
        assertEquals(endPosition, pawn.move(direction, distance));
    }
}
