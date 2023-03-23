package School;

import java.lang.reflect.Field;

public class StudentInfoInjector {
    public static void inject(Object student) {

        Field[] fields = student.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(StudentInfo.class)) {
                StudentInfo studentInfo = field.getAnnotation(StudentInfo.class);
                field.setAccessible(true);

                try {
                    field.set(student, new Student(studentInfo.name(), studentInfo.surname(), studentInfo.age()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
