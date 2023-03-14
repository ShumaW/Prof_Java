package BlockingQueue;

public class Main {

    public static void main(String[] args) {


    /*
    BlockingQueue:
    Класс Продьюсер - генерирует сообщения в очередь
    Класс Консьюмер - забирает сообщения из очереди
    Задача - реализовать класс Consumer, который
    будет анализировать сообщения в очереди и при
    входящем сообщении "exit" заканчивать работу.
    При реализации можно использовать класс
    MyBlockingQueue или ReentrantLockBlockingQueue
    в репозитории или одну из стандартных
    реализаций BlockingQueue из библиотеки.
     */

        BlockingQueue<String> queue = new BlockingQueue<String>();
        Producer producer = new Producer(queue, 15);
        Consumer consumer1 = new Consumer(queue);


        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer1);

        t1.start();
        t2.start();

    }
}
