package com.suetham.AStarAlgorithm;

import com.suetham.Dijkstra.Coordinate;

public class AStarAlgorithm {
    private int heuristicFn(Coordinate current, Coordinate goal) {
        return (int) Math.sqrt((current.xAxis() - goal.xAxis()) * 2 + (current.yAxis() - goal.yAxis()) * 2);
    }

    public void handle( ) {}
}
