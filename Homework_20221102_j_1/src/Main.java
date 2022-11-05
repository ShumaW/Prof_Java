import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        1 задача
• Создать интерфейс MailDeliveryService с одним методом void sendMail().
• Создайте класс DHL, который должен реализовать интерфейс MailDeliveryService.
    Его способ отправки почты — напечатать что-то вроде: «Положи письмо в конверт,
    поставь марку, отправь».
• Создайте класс Email, который должен реализовать интерфейс MailDeliveryService.
    Его способ отправки почты - напечатать что-то вроде: «Отправить по Интернету».
• Создайте класс Pigeon, который должен реализовать интерфейс MailDeliveryService.
    Его способ отправки почты — напечатать что-то вроде: «Голубь?! Серьезно!? в
    двадцать первом веке?!!! Ты сумасшедший! Я улетаю»
• Создайте класс Sender. Реализуйте в нем метод send(), который в качестве
    аргумента MailDeliveryService и отправляет почту с помощью данной службы.
• Реализуйте диалог с пользователем (использовать Scanner), как отправлять почту
    и отправлять ее с помощью Sender.

         */
        System.out.println("Рады видеть вас у нас в офисе!");
        System.out.println("Какой из нижеперечисленных служб доставки вы хотели бы воспользоваться?");
        System.out.println("DHL - 1");
        System.out.println("Email - 2");
        System.out.println("Pegion - 3");
        System.out.println("Введите пожалуйста номер выбранной службы (1, 2, 3)");

        Scanner scanner=new Scanner(System.in);
        int mail = scanner.nextInt();
        Sender m1 = new Sender();
        m1.send(mail);
    }
}