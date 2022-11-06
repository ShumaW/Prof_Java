public class Employee {

    private String lastName;
    private int age;

    public Employee(String name, int age) {
        this.lastName = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return lastName + " " + age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
