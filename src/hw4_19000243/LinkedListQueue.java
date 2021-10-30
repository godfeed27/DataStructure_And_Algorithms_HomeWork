package hw4_19000243;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {

    class Node {
        E element;
        Node next;

        public Node(E element, LinkedListQueue<E>.Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {}
    }

    private Node top = null;
    private Node bot = null;
    private int size = 0;

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator();
    }

    class LinkedListQueueIterator implements Iterator<E> {
        private Node currentNode = top;

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

    @Override
    public void enqueue(E element) {
        if (isEmpty()) {
            bot = top = new Node(element, null);
            size++;
        } 
        else if (top.next == null) {
            bot = new Node(element, null);
            top.next = bot;
            size++;
        } 
        else {
            Node newNode = new Node(element, null);
            bot.next = newNode;
            bot = newNode;
            size++;
        }
    }

    @Override
    public E dequeue() {
        Node newNode = top;
        top = top.next;
        size--;
        return newNode.element;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    void print() {
        System.out.print("Sequence: ");
        Node node = top;
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.next;
        }
        System.out.print("Top: " + top.element + "\n");
    }

    int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> arr = new LinkedListQueue<>();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : a) {
            arr.enqueue(i);
        }
        arr.print();
        System.out.println("Size: " + arr.size);
        System.out.println("Take the top: " + arr.dequeue());
        arr.print();
        System.out.println("Is the sequence empty: " + arr.isEmpty());
    }

}
