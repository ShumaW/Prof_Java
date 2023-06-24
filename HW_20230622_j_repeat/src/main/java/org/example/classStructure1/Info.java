package org.example.classStructure1;

import lombok.*;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Info {

    private final Map<Position,String> positionStringMap = new TreeMap<>();

    public String checker(Employee employee){
        for (Map.Entry<Position,String> entry : positionStringMap.entrySet()) {
            if (employee.getPosition().equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }

    public double avgSalary(Department department, Set<Employee> employeeSet){
        double sum = 0;
        int countEmployee = 0;
        for (Employee employee : employeeSet) {
            if (department.equals(employee.getDepartment())){
                sum += employee.getSalary();
                countEmployee++;
            }
        }
        return sum / countEmployee;
    }

    public void maxSalary(Department department, Set<Employee> set){
        double maxSalary = -1;
        String nameOfEmployee = "";
        for (Employee employee : set) {
            if (employee.getDepartment().equals(department)){
                if (employee.getSalary() > maxSalary){
                    maxSalary = employee.getSalary();
                    nameOfEmployee = employee.getName();
                }
            }
        }
        System.out.println(nameOfEmployee + " : " + maxSalary);
    }

    public void minSalary(Department department, Set<Employee> set){
        double minSalary = -1;
        String nameOfEmployee = "";
        for (Employee employee : set) {
            if (employee.getDepartment().equals(department)){
                if (employee.getSalary() < minSalary){
                    minSalary = employee.getSalary();
                    nameOfEmployee = employee.getName();
                }
            }
        }
        System.out.println(nameOfEmployee + " : " + minSalary);
    }

    public void getPromotion(Employee employee){
        int indexOfPosition = -1;
        Position[] positions = Position.values();
        for (int i = 0; i < positions.length; i++) {
            if (employee.getPosition().equals(positions[i])){
                indexOfPosition = i;
            }
        }
        employee.setPosition(positions[indexOfPosition + 1]);
        employee.setSalary(employee.getSalary() * 1.25);
    }
}
