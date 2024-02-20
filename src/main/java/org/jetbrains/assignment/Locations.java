package org.jetbrains.assignment;

import java.util.ArrayList;
import java.util.List;

public class Locations {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        List<Location> locations;
        Location currentLocation;

        public Builder() {
            this.locations = new ArrayList<>();
            this.currentLocation = new Location(0, 0);
            this.locations.add(currentLocation);
        }

        public Builder move(Movement movement) {
            this.currentLocation = this.currentLocation.move(movement);
            this.locations.add(this.currentLocation);
            return this;
        }

        public List<Location> build() {
            return this.locations;
        }
    }

}
