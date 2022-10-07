public class Main {
    public static void main(String[] args) {
        String[] students = {"Ivanov", "Petrov", "Vasechkin", "Protasov", "Pupkin"};
        double[] ball = {4.8, 4.2, 5.0, 4.8, 4.9};
        String []studName = {"Jack", "John", "Stan", "Ed"};
        double [] ball3 = {3.5, 4.2, 4.8, 4.1};

        System.out.println("------------ Level 1 ---------------");
        System.out.println("Best student is " + nameBestStudent(students, ball));
        System.out.println("------------ Level 2 ---------------");
        studentAndBall(studName , ball3, 4.0 );
    }

    /*  1.  Дано 2 массива. Первый массив String[] содержит имена студентов.
    Второй массив double[] содержит средний балл  студентов. i-й элемент первого
     массива соответствует i-элементу второго массива. Длины массивов равны.
     Необходимо написать метод, который возвращает имя самого успешного студена.
     В данной задаче, если 2 и более студента имеют лучший бал, метод может
     вернуть имя любого из них.
    */

    public static String nameBestStudent(String[] students, double[] ball1) {
        double bestBall = 0;
        String bestStudent = "";

        for (int i = 0; i < ball1.length; i++) {
            if (bestBall < ball1[i]) {
                bestBall = ball1[i];
                bestStudent = students[i];
            }
        }
        return bestStudent;
    }

    /*
     Исходные условия как у предыдущей задачи, т.е. дано два массива один
     с именами другой с средним баллом, но ваш метод должен выдавать строку
     вида имя1 - балл1:имя2 - балл2:имя3 - балл3 ….для всех студентов, чей балл
     выше заданного значения. Например:
     {“Jack”, “John”, “Stan”, “Ed”}, {3.5, 4.2, 4.8, “4.1”}, 4.0 ->
      “John - 4.2:Stan - 4.8:Ed - 4.1”
     */
    public static void studentAndBall(String[] studName, double[] ball2, double ball3) {
        for (int i = 0; i < studName.length; i++) {
            if (ball2[i] > ball3) {
                System.out.print(studName[i] + " - " + ball2[i] + " : ");
            }
        }
    }
}