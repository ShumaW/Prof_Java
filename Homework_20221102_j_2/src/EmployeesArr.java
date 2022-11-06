import java.util.Arrays;

public class EmployeesArr {
    private Employee[] employeesArray;
    private int size;
    private int capasity;


    public EmployeesArr(int capasity) {
        this.capasity = capasity;
        employeesArray = new Employee[capasity];
        size = 0;
    }

    public EmployeesArr(Employee employee) {
    }

    public boolean add(Employee emp) {
        if (size >= employeesArray.length) {
            enlarge();
        }
        employeesArray[size] = emp;
        size++;
        return true;
    }

//    @Override
//    public void add(EmployeesArr employeesArr) {
//
//    }

    private void enlarge() {
        Employee[] arr = new Employee[employeesArray.length * 2];
        for (int i = 0; i < employeesArray.length; i++) {
            arr[i] = employeesArray[i];
        }
        employeesArray = arr;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++) {
            res.append(employeesArray[i])
                    .append(System.lineSeparator());
        }
        return res.append("---------------")
                .append(System.lineSeparator())
                .append("Total: " + size + " employees")
                .toString();
                    }

//    public Employee get(int index) {
//        if (index < size) {
//            return employeesArray[index];
//        } else {
//            return null;
//        }
//    }


}
