package org.jetbrains.assignment;

import java.util.List;

public class Request {
    List<Movement> movements;
    List<Location> locations;

    public Request(List<Movement> movements, List<Location> locations) {
        this.movements = movements;
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Request{" +
                "movements=" + movements +
                ", locations=" + locations +
                '}';
    }
}
