/** Задача 1 (Сложность: 4/10):
 * Напишите параметризированный класс "Pair", который принимает два различных типа данных в качестве
 * параметров (например, "Pair"). Реализуйте методы для получения и установки значений каждого из элементов пары.
 */
public class Pair {
    private String name;
    private int age;

    public Pair(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
