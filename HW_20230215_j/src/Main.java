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


        try {
            getLoginAndPassword();
        } catch (WrongLoginException e) {
            throw new RuntimeException(e);
        } catch (WrongPasswordException e) {
            throw new RuntimeException(e);
        }


    }

    private static void getLoginAndPassword() throws WrongLoginException, WrongPasswordException {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter login:");
        String login = scanner.nextLine();
        Pattern p1 = Pattern.compile("\\w");
        Matcher m1 = p1.matcher(login);
        if (!m1.find() || login.length() > 20) throw new WrongLoginException("WRONG!!! You have entered incorrect login.");
        else
            System.out.println(true);


        System.out.println("Enter password :");
        String password = scanner.nextLine();
        Pattern p2 = Pattern.compile("\\w");
        Matcher m2 = p2.matcher(password);
        if (!m2.find() || password.length() > 20)
            throw new WrongPasswordException("WRONG!!! You have entered incorrect password.");
        else
            System.out.println(true);

        System.out.println("Confirm password :");
        String confirmPassword = scanner.nextLine();
        Pattern p3 = Pattern.compile("\\w");
        Matcher m3 = p3.matcher(confirmPassword);
        if (!password.equals(confirmPassword))
            throw new WrongPasswordException("WRONG!!! You have entered incorrect password.");
        else
            System.out.println(true);


        scanner.close();
    }
}