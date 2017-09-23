package com.thomasbenard.feedbackloop;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PositionTest {

    @Test
    @Parameters(method = "isCloserToThanData")
    public void isCloserToThanTest(Position position, Position target, Position other, boolean result) throws Exception {
        assertThat(position.isCloserTo(target).than(other), is(result));
    }

    private Object[] isCloserToThanData() {
        return new Object[]{
                new Object[]{new Position(0, 0), new Position(1,1), new Position(1,1), false},
                new Object[]{new Position(1, 1), new Position(1,1), new Position(0,0), true},
                new Object[]{new Position(1, 1), new Position(1,1), new Position(1,1), true},
                new Object[]{new Position(2, 0), new Position(3,0), new Position(1,0), true},
                new Object[]{new Position(4, 0), new Position(3,0), new Position(1,0), true},
                new Object[]{new Position(4, 0), new Position(3,0), new Position(2,0), true},
                new Object[]{new Position(0, 2), new Position(0,3), new Position(0,1), true},
                new Object[]{new Position(0, 2), new Position(0,3), new Position(0,1), true},
                new Object[]{new Position(4, 2), new Position(3,3), new Position(3,2), false}
        };
    }
}
