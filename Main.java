import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Main {
    /**
     * Implements the Producer-Consumer problem using Java threading.
     *
     * Two threads, a producer and a consumer, share a common, fixed-size buffer as a queue.
     * The producer's job is to generate data and put it into the buffer,
     * while the consumer's job is to consume the data from the buffer.
     *
     * Conditions to be maintained:
     * - Producer won't produce data if the buffer is full.
     * - Consumer won't consume data if the buffer is empty.
     *
     * This method sets up the environment, creates producer and consumer threads,
     * and manages synchronization between them to ensure data integrity and thread safety.
     */

    public static void main(String[] args) {


        System.out.println("before thread1" + Thread.currentThread().getName());
//        Queue<String> queue = new ArrayDeque<>(3);
        int BUFFER_SIZE = 3;
      BlockingQueue<String> queue = new LinkedBlockingQueue<>(BUFFER_SIZE);




        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();


        System.out.println("after thread1" + Thread.currentThread().getName());



    }


}
