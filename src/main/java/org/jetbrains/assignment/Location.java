package org.jetbrains.assignment;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int x = 0;
    private int y = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location move(Movement movement) {
        return switch (movement.getDirection()) {
            case EAST -> new Location(this.x + movement.getSteps(), this.y);
            case WEST -> new Location(this.x - movement.getSteps(), this.y);
            case NORTH -> new Location(this.x, this.y + movement.getSteps());
            case SOUTH -> new Location(this.x, this.y - movement.getSteps());
        };
    }

    public List<Movement> move(Location location) {
        List<Movement> movements = new ArrayList<>();
        if (this.x > location.x) {
            Movement movement = new Movement();
            movement.setDirection(Direction.WEST);
            movement.setSteps(this.x - location.x);
            movements.add(movement);
        }
        if (this.x < location.x) {
            Movement movement = new Movement();
            movement.setDirection(Direction.EAST);
            movement.setSteps(location.x - this.x);
            movements.add(movement);
        }
        if (this.y > location.y) {
            Movement movement = new Movement();
            movement.setDirection(Direction.SOUTH);
            movement.setSteps(this.y - location.y);
            movements.add(movement);
        }
        if (this.y < location.y) {
            Movement movement = new Movement();
            movement.setDirection(Direction.NORTH);
            movement.setSteps(location.y - this.y);
            movements.add(movement);
        }
        return movements;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
