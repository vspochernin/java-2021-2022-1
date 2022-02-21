package lab6;

import java.util.Random;

public class Process {

    private static State state = State.RUNNING;
    private static final Object mutex = new Object();
    private static Thread abstractProgram = new Thread(new AbstractProgram());


    static class AbstractProgram implements Runnable {

        @Override
        public void run() {
            Thread daemon = new Thread(() -> {
                while (true) {
                    Utils.pause(1000, 5000);
                    if (abstractProgram.isInterrupted()) {
                        break;
                    }
                    synchronized (mutex) {
                        //System.out.println("Демон: Состояние программы сейчас " + state.toString());
                        state = State.values()[new Random().nextInt(State.values().length)];
                        if (state.equals(State.RUNNING)) {
                            System.out.println("Демон: Программе повезло и состояние осталось RUNNING");
                        } else {
                            System.out.println("Демон: Я изменил состояние программы на: " + state.toString());
                        }
                        mutex.notify();
                    }
                }
            });
            daemon.setDaemon(true);
            daemon.start();
            System.out.println("Абстрактная программа: я заработала и запустила демона!");

            while (!Thread.currentThread().isInterrupted()) {
                someWork();
            }
        }

        private void someWork() {
            int aboba = 0;
            aboba++;
        }
    }

    static class Supervisor implements Runnable {

        @Override
        public void run() {
            System.out.println("Супервизор: я встал!");
            abstractProgram.start();
            while (!abstractProgram.isInterrupted()) {
                synchronized (mutex) {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    switch (state) {
                        case FATAL_ERROR -> stopProgram();
                        case UNKNOWN, STOPPING -> runProgram();
                        default -> System.out.println("Супервизор: Я ничего не сделал)");
                    }
                }
            }
        }

        private void runProgram() {
            state = State.RUNNING;
            System.out.println("Супервизор: Я перезапустил программу");
        }

        private void stopProgram() {
            abstractProgram.interrupt();
            System.out.println("Супервизор: Я остановил программу");
        }
    }

    public static void main(String[] args) {
        new Thread(new Supervisor()).start();
    }
}
