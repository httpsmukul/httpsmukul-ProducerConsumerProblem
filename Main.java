import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class Main {

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
