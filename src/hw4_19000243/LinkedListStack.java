package hw4_19000243;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {

    class Node {
        E element;
        Node next;

        public Node(E element, LinkedListStack<E>.Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {}
    }

    private Node stack = null;
    private int size = 0;

    @Override
    public void push(E element) {
        if (stack == null) {
            stack = new Node(element, null);
        }
        else {
            Node node = new Node(element, stack);
            stack = node;
        }
        size++;
    }

    @Override
    public E pop() {

        if (stack != null) {
            Node node = stack;
            stack = stack.next;
            size--;
            return node.element;
        }
        else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (stack == null) {
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
            return stack.element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }

    void print() {
        System.out.print("Sequence: ");
        Node node = stack;
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.next;
        }
        System.out.print("Top: " + top() + "\n");
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> arr = new LinkedListStack<>();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : a) {
            arr.push(i);
        }
        arr.print();
        System.out.println(arr.size);
        System.out.println("Take the top: " + arr.pop());
        arr.print();
        System.out.println("Is the sequence empty: " + arr.isEmpty());
    }
}
