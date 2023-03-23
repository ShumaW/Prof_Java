package School;
public class School {
    /**
     * Сделать по аналогии с примером с аннотацией  @MyName (см. код в репозитории):
     * Имеется класс Student с полями name, surname, age. Создать аннотацию @StudentInfo и соответствующий инжектор через рефлексию,
     * чтобы с их помощью иметь возможность инициализировать переменные типа Student. Например:
     * public class School {
     *
     * @StudentInfo(name = "Tom", surname = "Smith", age = 15)
     * private Student student1;
     * @StudentInfo(name = "Mary", surname = "Jennings", age = 17)
     * private Student student2;
     * }
     */
    @StudentInfo(name = "Tom", surname = "Smith", age = 15)
    private static Student student1;

    @StudentInfo(name = "Mary", surname = "Jennings", age = 17)
    private static Student student2;

    @StudentInfo(name = "Nick", surname = "Thomas", age = 16)
    private static Student student3;

    public static void main(String[] args) {
        School school = new School();

        StudentInfoInjector.inject(school);

        System.out.println(school.student1);
        System.out.println(school.student2);
        System.out.println(school.student3);
    }
}

