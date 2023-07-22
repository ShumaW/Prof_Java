package org.example.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Developer {
    private final String name;
    private final String lastName;
    private final int age;
    private Double salary;
    private final char gender;
    private Car car;

    @Override
    public String toString() {
        return name + " " + lastName +
                ", age: " + age +
                ", salary: " + salary +
                ", sex: " + gender +
                ", car: " + car + "\n";
    }
}
