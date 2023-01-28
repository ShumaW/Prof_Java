import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        /*
        Создать класс Employee

        2. Сгрупировать сотрудников по должности

        3. Вычислить среднюю зарплату всех сотрудников

        4. Получить список сотрудников с зп > 1000

        5. Получить список сотрудников из отдела маркетинг и увеличить зп на 15%

        6. Получить сотрудника с самой низкой зп

        7. Получите сотрудников из всех отделов с максимальной зп
         */

        Employee em1 = new Employee("Nick", "manager", "Marketing", 4500);
        Employee em2 = new Employee("John", "economist", "Economic", 3000);
        Employee em3 = new Employee("Ann", "accountant", "Marketing", 3200);
        Employee em4 = new Employee("Jack", "driver", "Garage", 1000);
        Employee em5 = new Employee("Patric", "driver", "Garage", 1200);
        Employee em6 = new Employee("Sem", "specialist", "Garage", 2500);

        List<Employee> employees = new ArrayList<>();
        employees.add(em1);
        employees.add(em2);
        employees.add(em3);
        employees.add(em4);
        employees.add(em5);
        employees.add(em6);

        System.out.println(employees);

        System.out.println("-".repeat(25) + " Сгрупировать сотрудников по должности " + "-".repeat(25));

        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition)));

        System.out.println("-".repeat(25) + " Вычислить среднюю зарплату всех сотрудников " + "-".repeat(25));

        System.out.println(employees.stream()
                .mapToDouble(Employee::getSalary)
                .average());

        System.out.println("-".repeat(25) + " Получить список сотрудников с зп > 1000 " + "-".repeat(25));

        System.out.println(employees.stream()
                .filter(x -> x.getSalary() > 1000)
                .collect(Collectors.toList()));

        System.out.println("-".repeat(25) + " Получить список сотрудников из отдела маркетинг и увеличить зп на 15% " + "-".repeat(25));

        System.out.println(employees.stream()
                //.filter(x -> x.getDepartment().equals("Marketing"))
//                .peek(x -> x.setSalary(x.getSalary() * 1.15))
                .map(x -> new Employee(x.getName(), x.getPosition(),x.getDepartment() ,x.getSalary() * 1.15))
                .collect(Collectors.toList()));
        System.out.println("Old employees :" + employees);

        System.out.println("-".repeat(25) + " Получить сотрудника с самой низкой зп " + "-".repeat(25));

        System.out.println(employees.stream()
                .sorted(((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())))
                .findFirst());

        System.out.println("-".repeat(25) + " Получите сотрудников из всех отделов с максимальной зп " + "-".repeat(25));

//        System.out.println("-".repeat(25) + " Вариант 1 " + "-".repeat(25));
//
//        System.out.println(employees.stream()
//                        .filter(list -> list.getDepartment().equals("Marketing"))
//                .sorted(((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())))
//                .findFirst());
//
//        System.out.println(employees.stream()
//                .filter(list -> list.getDepartment().equals("Economic"))
//                .sorted(((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())))
//                .findFirst());
//
//        System.out.println(employees.stream()
//                .filter(list -> list.getDepartment().equals("Garage"))
//                .sorted(((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())))
//                .findFirst());

        System.out.println("-".repeat(25) + " Вариант 2 " + "-".repeat(25));

        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary)))));
    }
}