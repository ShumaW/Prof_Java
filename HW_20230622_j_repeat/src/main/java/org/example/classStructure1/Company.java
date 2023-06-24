package org.example.classStructure1;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Company {

    private String name;
    private Set<Employee> employees;
    private Set<Department> departments;
}
