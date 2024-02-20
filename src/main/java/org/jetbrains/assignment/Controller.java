package org.jetbrains.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    @Autowired
    ShithouseDatabase database;
    @PostMapping(value = "/locations")
    public List<Location> locations(@RequestBody List<Movement> movements) {
        var builder = Locations.builder();
        movements.forEach(builder::move);
        var locations =  builder.build();
        this.database.INSERT(new Request(movements, locations));
        System.out.println(this.database.SELECT(this.database.COUNT() - 1));
        return locations;
    }

    @PostMapping(value = "/moves")
    public List<Movement> moves(@RequestBody List<Location> locations) {
        List<Movement> movements = new ArrayList<>();
        for (int i = 1; i < locations.size(); i++) {
            movements.addAll(locations.get(i-1).move(locations.get(i)));
        }
        this.database.INSERT(new Request(movements, locations));
        System.out.println(this.database.SELECT(this.database.COUNT() - 1));
        return movements;
    }
}