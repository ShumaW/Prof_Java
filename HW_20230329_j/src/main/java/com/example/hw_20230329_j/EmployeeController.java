package com.example.hw_20230329_j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    /**
     * Через контроллер EmployeeController (см. код в репозитории) реализовать:
     *
     * REST запрос на вывод списка всех Employee, чье имя начинается на определенные буквы.
     *
     * REST запрос на вывод общего количества сотрудников.
     *
     * REST запрос на заполнение всех пустых полей surname у списка Employee
     * значением "Not provided".
     *
     * REST запрос на удаление из списка Employee всех сотрудников, у которых age < 18.
     *
     * Проверить работу запросов через Postman.
     */
    private List<Employee> employees = new ArrayList<>();

    public EmployeeController() {
        employees.addAll(Arrays.asList(
                new Employee("Tom"),
                new Employee("Jane"),
                new Employee("Mary"),
                new Employee("Mark")
        ));
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employees;
    }

    @GetMapping(value = "/find")
    public Optional<Employee> findEmployee(@RequestParam(required = false) String id,
                                           @RequestParam(required = false) String name) {
        return employees.stream().filter(employee -> {
            if (id != null) {
                if (name != null) {
                    return employee.getId().equals(id) && employee.getName().equals(name);
                } else {
                    return employee.getId().equals(id);
                }
            }
            return employee.getName().equals(name);
        }).findAny();
    }

    @GetMapping(value = "/find_by_char")  // localhost:8080/employees/find_by_char?s=M
    public List<Employee> findEmployeeByChar(@RequestParam char s){
        List<Employee> list = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getName().charAt(0) == s){
                list.add(e);
            }
        }
        return list;
    }

    @GetMapping(value = "/count_employees")  // localhost:8080/employees/count_employees
    public int countOfEmployee(){
        return employees.size();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employees.add(employee);
        return employee;
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmplyee(@RequestBody Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(employee.getId())) {
                employees.set(i, employee);
                return new ResponseEntity<>(employee, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(addEmployee(employee), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Employee> updateEmplyeeSurnameAge(@PathVariable String id,
                                                            @RequestParam String surname,
                                                            @RequestParam int age) {
        Optional<Employee> employeeToUpdate = employees.stream().filter(employee -> employee.getId().equals(id)).findAny();
        if (employeeToUpdate.isPresent()){
            Employee employee = employeeToUpdate.get();
            employee.setSurname(surname);
            employee.setAge(age);
            return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
        }
        return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/default_surname")                  // localhost:8080/employees/default_surname?s=Not provided
    public void updateEmployeeSurname(@RequestParam String s){   // проверка localhost:8080/employees
        for (Employee e : employees) {
            if (e.getSurname() == null){
                e.setSurname(s);
            }
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEmployee(@PathVariable String id) {
        Employee employeeFromList = employees.stream()
                .filter(e -> id.equals(e.getId()))
                .findAny()
                .get();
        employees.remove(employeeFromList);
    }

    @DeleteMapping(value = "/delete_by_age")         // localhost:8080/employees/delete_by_age?age=18
    public void deleteEmpByAge(@RequestParam int age){  // проверка localhost:8080/employees
        employees.removeIf(e -> e.getAge() < age);
    }
}
