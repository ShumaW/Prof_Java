package org.example.classStructure1;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private String name;
    private Department department;
    private Position position;
    private double salary;
}
