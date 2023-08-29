package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void myThreadTest()  {
        Warehouse warehouse = new Warehouse(10,0);
        Producer producer = new Producer(warehouse);
        Consumer consumer = new Consumer(warehouse);

        Thread threadProducer = new Thread(() -> {
            producer.produceItems(1);
        });
        Thread threadConsumer = new Thread(() -> {
            consumer.consumeItems(1);
        });

        threadProducer.start();
        threadConsumer.start();

        int expected = 0;

        assertEquals(expected,warehouse.getAvailableItems());
    }
}