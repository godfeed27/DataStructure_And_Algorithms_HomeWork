package hw4_19000243;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    static final int CAPACITY = 1000;
    E[] data;
    int t = -1; // chỉ số top

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public ArrayStack() {
        data = (E[]) new Object[CAPACITY];
    }

    public int size() {
        return t + 1;
    }

    @Override
    public void push(E element) {
        if (size() == data.length) {
            E[] extraData = (E[]) new Object[data.length + 1000];
            for (int i = 0; i < size(); i++) {
                extraData[i] = data[i];
            }
            extraData[size()] = element;
            t++;
            data = extraData;
        }
        else {
            data[size()] = element;
            t++;
        }
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E resuit = data[t];
        t--;
        return resuit;
    }

    @Override
    public boolean isEmpty() {
        if (t == -1) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        else {
            return data[t];
        }
    }

    void print() {
        System.out.print("Sequence: ");
        for (int i = t; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.print("Top: " + top() + "\n");
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arr = new ArrayStack<>();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : a) {
            arr.push(i);
        }
        arr.print();
        System.out.println("Take the top: " + arr.pop());
        arr.print();
        System.out.println("Is the sequence empty: " + arr.isEmpty());
    }
}
