package hw4_19000243;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            return num < count;
        }

        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }

    @Override
    public void enqueue(E element) {
        if (n == count) {
            System.out.println("full");
        }
        else {
            int idx = (top + count) % n;
            queue[idx] = element;
            count++;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            return null;
        E temp = queue[top];
        queue[top] = null;
        top = (top + 1) % n;
        count--;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    void print() {
        int i = 0;
        System.out.print("Sequence: ");
        while (i < count) {
            System.out.print(queue[(top + i) % n]);
            i++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayQueue<Integer> b = new ArrayQueue<>(6);
        for (int i : a) {
            b.enqueue(i);
        }
        b.print();
        b.dequeue();
        b.enqueue(11);
        b.dequeue();
        b.dequeue();
        b.enqueue(12);
        b.print();
    }
}
