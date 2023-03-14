package BlockingQueue;

import java.util.Scanner;

public class Producer implements Runnable{
    private BlockingQueue<String> queue;
    int size;

    public Producer(BlockingQueue<String> queue, int size) {
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = 0; i < size; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter а word (\"exit\" is finish program!) : ");
            String word = scanner.nextLine();
            if (word.equals("exit")){
                queue.put(word);
                break;
            } else {
                queue.put(word);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
