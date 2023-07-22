package org.example.entity;

import lombok.*;

@Getter
@AllArgsConstructor
public class Car {

    private final Color color;
    private final boolean sports;
    private final Brand brand;
    private final Integer maxSpeed;

    @Override
    public String toString() {
        return "Auto: " + brand +
                ", color: " + color +
                ", sports: " + sports +
                ", maxSpeed: " + maxSpeed + " km/h";
    }
}
