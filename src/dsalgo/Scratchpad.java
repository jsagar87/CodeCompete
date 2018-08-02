package dsalgo;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Scratchpad {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> fifoThreadQueue = new LinkedBlockingQueue<>();

        Thread feeder = new Thread(new Producer(fifoThreadQueue));
        feeder.start();
        fifoThreadQueue.add("Thread - sagar");
        fifoThreadQueue.add("Thread - rupesh");
        fifoThreadQueue.add("Thread - umesh");
        fifoThreadQueue.add("Thread - ashwin");
        fifoThreadQueue.add("Thread - ajay");

        String threadCursor = "";
        int queueInitialSize = fifoThreadQueue.size();
        for (int i = 0; i <= queueInitialSize; i++) {
            threadCursor = fifoThreadQueue.take();
            processThread(threadCursor);
        }
    }

    private static void processThread(String threadname) {
        System.out.println(threadname);
    }

}
