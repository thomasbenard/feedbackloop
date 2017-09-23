package com.thomasbenard.feedbackloop;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ScenarioTest {


    @Test
    @Parameters(method = "runScenarioData")
    public void runScenarioTest(Position startPosition, Position endPosition, DirectionGenerator directionGenerator, int moveDistance, final int expectedResult) throws Exception {
        Scenario scenario = new Scenario(startPosition, endPosition, directionGenerator);
        assertThat(scenario.run(moveDistance), is(expectedResult));
    }

    private Object[] runScenarioData() {
        return new Object[]{
                new Object[]{new Position(0, 0), new Position(0, 10), new AlwaysNorth(), 1, 10},
                new Object[]{new Position(0, 0), new Position(0, 10), new AlwaysNorth(), 5, 2},
                new Object[]{new Position(0, 0), new Position(0, 20), new AlwaysNorth(), 1, 20},
                new Object[]{new Position(0, 0), new Position(0, -30), new AlwaysSouth(), 1, 30},
                new Object[]{new Position(0, 0), new Position(0, 3), new TwoNorthOneSouth(), 1, 4}
        };
    }

    @Test
    @Parameters(method = "computeAverageReachingDurationData")
    public void computeAverageReachingDurationTest(List<Integer> results, int moveDistance, double expectedResult) throws Exception {
        assertThat(Scenario.computeAverageReachingDuration(results, moveDistance), is(expectedResult));
    }

    private Object[] computeAverageReachingDurationData() {
        return new Object[]{
                new Object[]{Arrays.asList(1), 1, 1},
                new Object[]{Arrays.asList(2), 1, 2},
                new Object[]{Arrays.asList(1, 2), 1, 1.5},
                new Object[]{Arrays.asList(1, 2, 3), 1, 2},
                new Object[]{Arrays.asList(1, 2, 3), 2, 4}
        };
    }
}
