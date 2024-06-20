
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {

        System.out.println("Producer thread before timer ++++++++++++++++++++");
        try {
            int stop = 0;
            while (true && stop < 10) {
                stop++;
                String item = "Item " + (int) (Math.random() * 100);
                queue.put(item); // Blocks if the buffer is full
                System.out.println("Produced " + item);
//                Thread.sleep((int) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }




        System.out.println("Producer thread after timer ++++++++++++++++++++");
        System.out.println(queue);

    }
}
