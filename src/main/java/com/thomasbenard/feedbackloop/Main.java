package com.thomasbenard.feedbackloop;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        runSimulation(1);
        runSimulation(10);
        runSimulation(100);
        runSimulation(1000);
    }

    private static void runSimulation(int moveDistance) {
        System.out.println("Result for moveDistance " + moveDistance + " is " +
                Scenario.computeAverageReachingDuration(runScenarios(moveDistance), moveDistance));
    }

    private static ArrayList<Integer> runScenarios(int moveDistance) {
        ArrayList<Integer> scenarioResults = new ArrayList<Integer>();
        for (int i = 0; i < 10000; i++) {
            Scenario scenario = new Scenario(new Position(0, 0, 0, 0, 0),
                    new Position(1000, 1000, 1000, 1000, 1000),
                    new RandomDirectionGenerator(5));
            scenarioResults.add(scenario.run(moveDistance));
        }
        return scenarioResults;
    }
}
