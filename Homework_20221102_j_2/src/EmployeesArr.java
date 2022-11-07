public class EmployeesArr implements GetArray{
    private Employee[] employeesArray;
    private int size;
    private int capasity;


    public EmployeesArr(int capasity) {
        this.capasity = capasity;
        employeesArray = new Employee[capasity];
        size = 0;
    }


//    public boolean add(Employee emp) {
//        if (size >= employeesArray.length) {
//            enlarge();
//        }
//        employeesArray[size] = emp;
//        size++;
//        return true;
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


    @Override
    public boolean add(Employee emp) {
        if (size >= employeesArray.length) {
            enlarge();
        }
        employeesArray[size] = emp;
        size++;
        return true;
    }
}
