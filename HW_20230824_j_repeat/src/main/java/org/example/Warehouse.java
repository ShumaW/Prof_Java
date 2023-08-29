package org.example;
/*
Класс Warehouse:
Обеспечивает хранение и управление товарами на складе.
Содержит поле capacity для ограничения вместимости склада.
Содержит поле availableItems для отслеживания доступного количества товаров на складе.
Метод produce(int amount): Добавляет заданное количество товаров на склад.
Если нет места на складе, блокирует поток до освобождения места.
Метод consume(int amount): Изымает заданное количество товаров со склада.
Если товаров недостаточно, блокирует поток до появления достаточного количества товаров.
 */

import lombok.Getter;

import static java.lang.Thread.sleep;

@Getter
public class Warehouse {
    private final int capacity;
    private volatile int availableItems;

    public Warehouse(int capacity, int availableItems) {
        if (capacity <= 0 || availableItems < 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.availableItems = availableItems;
    }



    public synchronized void produce(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= amount; i++) {
            while (availableItems >= capacity) {
                try {
                    System.out.println("Producer waiting.");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            notifyAll();
            availableItems++;
            System.out.println("There are " + (capacity - availableItems) + " spaces left in stock");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void consume(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= amount; i++) {
            while (availableItems == 0) {
                try {
                    System.out.println("Consumer waiting.");
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            notifyAll();
            availableItems--;
            System.out.println(availableItems + " items left in stock");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}