public class Employee {

    private String name;
    private String position;

    private String department;
    private double salary;

    public Employee(String name, String position, String department, int salary) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee: " + name + ", position: " + position + ", department: " + department + ", salary: " + salary + "\n";
    }
}
