package org.jetbrains.assignment;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScope
@Service
public class ShithouseDatabase {
    private Integer requestNumber;
    private Map<Integer, Request> requests;
    public ShithouseDatabase() {
        this.requestNumber = 0;
        this.requests = new HashMap<>();
    }

    public void INSERT(Request request) {
        this.requests.put(requestNumber, request);
        this.requestNumber++;
    }

    public Request SELECT(int requestNumber) {
        return this.requests.get(requestNumber);
    }

    public int COUNT() {
        return this.requests.size();
    }
}
