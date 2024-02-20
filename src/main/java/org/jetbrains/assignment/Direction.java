package org.jetbrains.assignment;

public enum Direction {
    NORTH(1),
    EAST(1),
    SOUTH(-1),
    WEST(-1);

    private int delta;
    Direction(int i) {
        this.delta = i;
    }

    public int getDelta() {
        return delta;
    }
}