package com.suetham.Dijkstra;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int xAxis() {
        return x;
    }

    public void setXAxis(int x) {
        this.x = x;
    }

    public int yAxis() {
        return y;
    }

    public void setYAxis(int y) {
        this.y = y;
    }

    public String toString() {
        return "X: " + this.x + " Y: " + this.y;
    }
}
