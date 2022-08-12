package com.suetham.AStarAlgorithm;

public class AStarAlgorithm {
    private int heuristicFn(Coordinate current, Coordinate goal) {
        return (int) Math.sqrt((current.xAxis() - goal.xAxis()) * 2 + (current.yAxis() - goal.yAxis()) * 2);
    }
}
