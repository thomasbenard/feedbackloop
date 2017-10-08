package com.thomasbenard.feedbackloop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int moveDistance = 1;
        System.out.println("Result for moveDistance " + moveDistance + " is " +
                Scenario.computeAverageReachingDuration(runScenarios(moveDistance), moveDistance));
        moveDistance = 100;
        System.out.println("Result for moveDistance " + moveDistance + " is " +
                Scenario.computeAverageReachingDuration(runScenarios(moveDistance), moveDistance));

    }

    private static ArrayList<Integer> runScenarios(int moveDistance) {
        ArrayList<Integer> scenarioResults = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            Scenario scenario = new Scenario(new Position(0, 0), new Position(1000, 1500), new RandomDirectionGenerator(2));
            scenarioResults.add(scenario.run(moveDistance));
        }
        return scenarioResults;
    }
}
