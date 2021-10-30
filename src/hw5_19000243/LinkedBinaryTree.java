package hw5_19000243;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<Node<E>> {

    private int n = 0;
    private Node<E> root;

    public LinkedBinaryTree() throws FileNotFoundException {

    }

    public Node<E> addRoot(E element) {
        root = new Node<E>(element, null, null, null);
        n ++;
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        if (p.getLeft() != null) {
            throw new IllegalArgumentException("đã có left");
        }
        Node<E> node = new Node<E>(element, p, null, null);
        p.setLeft(node);
        n ++;
        return node;
    }

    public Node<E> addRight(Node<E> p, E element) {
        if (p.getRight() != null) {
            throw new IllegalArgumentException("đã có right");
        }
        Node<E> node = new Node<E>(element, p, null, null);
        p.setRight(node);
        n ++;
        return node;
    }

    public void set(Node<E> p, E element) {
        p.setElement(element);
    }

    @Override
    public Node<E> root() {
        return root;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(Node<E> p) {
        int count = 0;
        if (p.getLeft() != null) {
            count --;
        }
        if (p.getLeft() != null) {
            count --;
        }
        return count;
    }

    @Override
    public Node<E> parent(Node<E> p) {
        return p.getParent();
    }

    @Override
    public Node<E> left(Node<E> p) {
        return p.getLeft();
    }

    @Override
    public Node<E> right(Node<E> p) {
        return p.getRight();
    }

    @Override
    public Node<E> sibling(Node<E> p) {
        if (p.getParent().getLeft().equals(p)) {
            return p.getParent().getRight();
        }
        else {
            return p.getParent().getLeft();
        }
    }

    // print and write file
    // recursive with right root left order
    public void print(Node<E> p, String s, BufferedOutputStream bufferOut) throws IOException {
        if (p.getRight() != null) {
            print(p.getRight(), s + "     ", bufferOut);
        }
        byte[] b = (s + p.getElement() + "\n").getBytes();
        bufferOut.write(b);
        bufferOut.flush();
        System.out.println(s + p.getElement());
        if (p.getLeft() != null) {
            print(p.getLeft(), s + "     ", bufferOut);
        }
    }
}
