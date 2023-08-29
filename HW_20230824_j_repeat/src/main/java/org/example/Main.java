package org.example;

/*
Цель проекта:
Разработать многопоточную систему управления складом, которая
обеспечит безопасное добавление и изъятие товаров с использованием
механизмов синхронизации и средств многопоточности Java.

Описание компонентов:

Требования:
Используйте ключевое слово volatile для обеспечения видимости переменных availableItems между потоками.
Используйте ключевое слово synchronized для синхронизации методов produce и consume склада.
Используйте методы wait(), notify() и/или notifyAll() для реализации ожидания и оповещения между потоками.
 */

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse(10, 0);
        Producer producer = new Producer(warehouse);
        Consumer consumer = new Consumer(warehouse);

        Thread threadProducer = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running");
            producer.produceItems(30);
        });
        Thread threadConsumer = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is running");
            consumer.consumeItems(25);
        });

        threadProducer.start();
        threadConsumer.start();
    }
}