package lab7;

import java.util.concurrent.BlockingQueue;

public class WriterTask implements Runnable {

    private final BlockingQueue<String> queue;
    private static int num = 1;

    public WriterTask(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        lab6.Utils.pause(500, 1000);
        String message = "\"сообщение " + num++ + "\"";
        System.out.println(Thread.currentThread().getName() + ": пытается записать сообщение: " + message);
        try {
            queue.put("сообщение от " + Thread.currentThread().getName() + ": " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
