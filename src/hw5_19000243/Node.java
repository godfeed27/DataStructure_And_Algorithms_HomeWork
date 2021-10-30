package hw5_19000243;

public class Node<E> {
    private E element; // an element stored at this node

    private Node<E> parent; // a reference to the parent node (if any)
    private Node<E> left; // a reference to the left child
    private Node<E> right; // a reference to the right child
    // Constructs a node with the given element and neighbors. ∗/

    public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public Node() {
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}
