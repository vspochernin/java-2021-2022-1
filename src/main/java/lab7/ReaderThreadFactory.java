package lab7;

import java.util.concurrent.ThreadFactory;

public class ReaderThreadFactory implements ThreadFactory {

    private int num = 1;

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "Читающий поток " + num++);
    }
}
