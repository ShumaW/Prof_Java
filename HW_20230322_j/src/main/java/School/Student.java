package School;
public class Student {
    String name;
    String surname;
    int age;

    public Student(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student name: " + name + ", surname: " + surname + ", age: " + age;
    }
}
