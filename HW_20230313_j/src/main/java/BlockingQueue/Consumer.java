package BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }
    private boolean flag = true;
    @Override
    public void run() {
        while (flag) {
            if (queue.take().equals("exit")) {
                System.out.println("Program is finished!");
                flag = false;

            } else {
                String message = queue.take();
                System.out.println(Thread.currentThread().getName() + " received message: " + message +
                        " Elements in queue:" + queue.getSize());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
