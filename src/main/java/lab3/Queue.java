package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import lab3.chordata_sub.Mammalia;
import lab3.chordata_sub.mammalia_sub.Carnivora;
import lab3.chordata_sub.mammalia_sub.primates_sub.hominidae_sub.Homo;

public class Queue<T> {

    private int size;
    private final int capacity;
    private final List<T> data;

    public Queue(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException();
        }
        data = new ArrayList<>(initialCapacity);
        capacity = initialCapacity;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T object) {
        if (size == capacity) {
            throw new RuntimeException("Out of space in the queue");
        }
        data.add(object);
        ++size;
    }

    public T get() {
        if (size == 0) {
            throw new NoSuchElementException("There is no elements in the queue");
        }
        --size;
        return data.remove(0);
    }

    public Queue<? extends Mammalia> produce() {
        int count = 0;
        for (Object object : data) {
            if (object instanceof Mammalia) {
                ++count;
            }
        }
        if (count > 0) {
            Queue<Mammalia> newQueue = new Queue<>(count);
            for (Object object : data) {
                if (object instanceof Mammalia) {
                    newQueue.add((Mammalia) object);
                }
            }
            return newQueue;
        }
        return null;
    }

    public void consume(Queue<? extends Mammalia> queue) {
        if (queue == null) {
            return;
        }
        int countOfHomoParents = 0;
        int countOfCarnivoraParents = 0;
        for (Mammalia object : queue.data) {
            if (object instanceof Homo) {
                ++countOfHomoParents;
            }
            if (object instanceof Carnivora) {
                ++countOfCarnivoraParents;
            }
        }
        Queue<Mammalia> homoParents = new Queue<>(countOfHomoParents);
        Queue<Mammalia> carnivoraParents = new Queue<>(countOfCarnivoraParents);
        for (Mammalia object : queue.data) {
            if (object instanceof Homo) {
                homoParents.add(object);
            }
            if (object instanceof Carnivora) {
                carnivoraParents.add(object);
            }
        }
        System.out.println("Все люди:");
        while (homoParents.getSize() > 0) {
            System.out.println(homoParents.get());
        }
        System.out.println();
        System.out.println("Все хищные:");
        while (carnivoraParents.getSize() > 0) {
            System.out.println(carnivoraParents.get());
        }
    }
}
