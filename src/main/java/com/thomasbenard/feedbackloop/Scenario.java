package com.thomasbenard.feedbackloop;

import java.util.List;

public class Scenario {
    private Position position;
    private final Position endPosition;
    private final DirectionGenerator directionGenerator;

    public Scenario(Position startPosition, Position endPosition, DirectionGenerator directionGenerator) {
        this.position = startPosition;
        this.endPosition = endPosition;
        this.directionGenerator = directionGenerator;
    }

    public static double computeAverageReachingDuration(List<Integer> scenarioResults, int moveDistance) {
        int totalNumberOfSteps = 0;
        for (int result : scenarioResults) {
            totalNumberOfSteps += result;
        }
        double averageNumberOfSteps = (double)totalNumberOfSteps / scenarioResults.size();
        return averageNumberOfSteps * moveDistance;
    }

    public int run(int moveDistance) {
        int numberOfSteps = 0;
        Pawn pawn = new Pawn(position);
        while(!isScenarioFinished()){
            pawn = decidePawnNextPosition(moveDistance, pawn);
            numberOfSteps++;
        }
        return numberOfSteps;
    }

    private Pawn decidePawnNextPosition(int moveDistance, Pawn pawn) {
        Position originalPosition = position;
        position = pawn.move(directionGenerator.getNextDirection(), moveDistance);
        if(!position.isCloserTo(endPosition).than(originalPosition))
            pawn = new Pawn(originalPosition);
        return pawn;
    }

    private boolean isScenarioFinished() {
        return position.equals(endPosition);
    }
}
