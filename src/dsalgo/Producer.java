package dsalgo;

import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {
    BlockingQueue<String> fifoThreadQueue;

    public Producer(BlockingQueue<String> fifoThreadQueue){
        this.fifoThreadQueue = fifoThreadQueue;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            fifoThreadQueue.add("thread - manotosh");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}