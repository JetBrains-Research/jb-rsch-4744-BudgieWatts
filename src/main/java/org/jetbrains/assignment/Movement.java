package org.jetbrains.assignment;

public class Movement {
    private Direction direction;
    private int steps;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "direction=" + direction +
                ", steps=" + steps +
                '}';
    }
}