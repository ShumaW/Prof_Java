import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        /*
        Exceptions. Проверка логина и пароля
        Создать статический метод который принимает на вход три параметра: login,
        password и confirmPassword.
        Login должен содержать только латинские буквы, цифры и знак подчеркивания.
        Длина login должна быть меньше 20 символов.
        Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
        Password должен содержать только латинские буквы, цифры и знак подчеркивания.
        Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
        Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
        WrongPasswordException и WrongLoginException - пользовательские классы исключения
        с двумя конструкторами – один по умолчанию,
        второй принимает сообщение исключения и передает его в конструктор класса Exception.
        Обработка исключений проводится внутри метода.
        Используем multi-catch block. Метод возвращает true, если значения верны или
        false в другом случае.
     */

        checkLoginAndPassword();

    }

    private static final Pattern LOGIN = Pattern.compile("\\w");
    private static final Pattern PASS = Pattern.compile("\\w");

    public static void checkLoginAndPassword() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter login:");
            String login = scanner.nextLine();
            Matcher m1 = LOGIN.matcher(login);
            if (!m1.find() || login.length() > 20)
                throw new WrongLoginException("WRONG!!! You have entered incorrect login.");
            else
                System.out.println(true);

            System.out.println("Enter password :");
            String password = scanner.nextLine();
            Matcher m2 = PASS.matcher(password);
            if (!m2.find() || password.length() > 20)
                throw new WrongPasswordException("WRONG!!! You have entered incorrect password.");
            else
                System.out.println(true);

            System.out.println("Confirm password :");
            String confirmPassword = scanner.nextLine();
            if (!password.equals(confirmPassword))
                throw new WrongPasswordException("WRONG!!! You have entered incorrect password.");
            else
                System.out.println(true);

            scanner.close();
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            System.out.println(false);
        }
    }
}