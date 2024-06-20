import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {


    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        System.out.println("Consumer thread before timer ++++++++++++++++++++");
        try {
            while (true) {
                Thread.sleep(8000);
                String item = queue.take(); // Blocks if the buffer is empty
                System.out.println("Consumed " + item);
//                Thread.sleep((int) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Consumer thread after timer ++++++++++++++++++++");
    }
}
