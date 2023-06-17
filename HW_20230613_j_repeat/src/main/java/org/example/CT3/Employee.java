package org.example.CT3;

import lombok.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 1:
 * Создайте класс Employee, содержащий информацию о сотрудниках в виде Map<Integer, String>,
 * где ключом является идентификатор сотрудника, а значением - его имя.
 */

@Getter
@Setter
public class Employee {

    private Map<Integer, String> mapEmployee;

    public Employee() {
        mapEmployee = new LinkedHashMap<>();
    }

    public void addEmployee(Integer id, String name) {
        mapEmployee.put(id, name);
    }

    public void removeEmployee(int id) {
        mapEmployee.remove(id);
    }

}
