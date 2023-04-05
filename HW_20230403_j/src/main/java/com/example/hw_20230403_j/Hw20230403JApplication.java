package com.example.hw_20230403_j;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hw20230403JApplication {
    /**
     * Создайте класс Order с полями item и price. Добавьте бин в свой файл конфигурации.
     * Создайте класс PaymentGateway, в котором будет присутствовать поле Order.
     *
     * public class PaymentGateway {
     *     private Order order;
     *     @Override
     *     public String toString(){
     *         return "ordering "+this.order.getItem()+" | price: "+this.order.getPrice();
     *     }
     * }
     *
     * Выполните шаги по конфигурации бинов так, как была показано на уроке:
     * а) С применением xml конфигурации
     * б) С применением java-конфигурации и @Autowired
     */

    public static void main(String[] args) {

//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("hw20230403application.xml");
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppAutoContext.class);
        System.out.println();

        PaymentGateway paymentGateway1 = (PaymentGateway) context.getBean("gateway1");
        PaymentGateway paymentGateway2 = (PaymentGateway) context.getBean("gateway2");

        System.out.println(paymentGateway1);
        System.out.println(paymentGateway2);


    }

}
