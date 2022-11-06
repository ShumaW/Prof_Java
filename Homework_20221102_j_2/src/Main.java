import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        2 задача
        Представьте, что в нашей программе мы обрабатываем массив
        (например, массив целых чисел или массив сотрудников,
        если хотите). В production мы запрашиваем ввод массива от
        пользователя (используем сканер), в тестовой среде мы получаем
        его как случайный массив или используем массив, определенный в коде.
        Итак, вам нужно реализовать метод getArray(), который в качестве
        аргумента принимает способ создания массива и в результате возвращает
        массив.
        Реализуйте эту программу (подсказка: используйте знания об интерфейсе)
         */
        System.out.println("Для начала набора базы данных сотрудников введите фамилию и возраст.");
        int finish = 1;
        EmployeesArr empArr = new EmployeesArr(1);
        Scanner scanner = new Scanner(System.in);
        while (finish != 2) {
            System.out.println("Введите фамилию работника:");
            String lastName = scanner.next();
            System.out.println("Введите возраст работника:");
            int age = scanner.nextInt();
            empArr.add(new Employee(lastName, age));

            System.out.println("Для продолжения набора введите цифру 1");
            System.out.println("Для завершения набора введите цифру 2 !!!");
            finish = scanner.nextInt();

        }
        System.out.println(empArr);
        scanner.close();

    }
}