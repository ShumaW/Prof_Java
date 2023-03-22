package ReentrantLockBlockingQueue;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockBlockingQueue<T> {
    /*
    Переписать класс ReentrantLockBlockingQueue  так, чтобы:

    - очередь была на основе массива (ArrayDeque)

    - размер очереди задавался через пареметр size в конструкторе

    - при попытки положить элемент в заполненную очередь поток-продьюсер
    ожидал бы освобождение места

     */


    private int size;
    public ReentrantLockBlockingQueue(int size) {
        this.size = size;
        this.queue = new ArrayDeque<>(size);
    }

    private Queue<T> queue = new ArrayDeque<>(size);
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition queueIsEmpty = lock.newCondition();
    private Condition queueIsFull = lock.newCondition();


    public void put(T item) {
        lock.lock();
        try {
            while (queue.size() >= size) {
                queueIsFull.awaitUninterruptibly();
            }
            queue.add(item);
            queueIsEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                queueIsEmpty.awaitUninterruptibly();
            }
            queueIsFull.signal();
            return queue.poll();
        } finally {
            lock.unlock();
        }

    }


    public int getSize() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

}