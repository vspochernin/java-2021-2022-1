package lab7;

import java.util.concurrent.BlockingQueue;

public class ReaderTask implements Runnable {

    private final BlockingQueue<String> queue;

    public ReaderTask(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        lab6.Utils.pause(500, 8000);
        System.out.print(Thread.currentThread().getName() + ": прочитал ");
        try {
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
