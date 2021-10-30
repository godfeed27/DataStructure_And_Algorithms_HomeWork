package hw5_19000243;

import java.io.FileNotFoundException;

public class ExpressionTree<E> extends LinkedBinaryTree<E> {

    public ExpressionTree() throws FileNotFoundException {
        super();
    }

    public void preorderPrint(Node<E> p) {
        System.out.print(p.getElement() + " ");
        if (p.getLeft() != null) {
            preorderPrint(p.getLeft());
        }
        if (p.getRight() != null) {
            preorderPrint(p.getRight());
        }
    }

    public void postorderPrint(Node<E> p) {
        if (p.getLeft() != null) {
            postorderPrint(p.getLeft());
        }
        if (p.getRight() != null) {
            postorderPrint(p.getRight());
        }
        System.out.print(p.getElement() + " ");
    }

    public void inorderPrint(Node<E> p) {
        if (p.getLeft() != null) {
            System.out.print("( ");
            inorderPrint(p.getLeft());
        }
        System.out.print(p.getElement() + " ");
        if (p.getRight() != null) {
            inorderPrint(p.getRight());
            System.out.print(") ");
        }
    }

    // if it is a leaf, return the value otherwise perform calc(left, root, right)
    public double getResult(Node<E> p) {
        if (!check(String.valueOf(p.getElement()))) {
            return Double.parseDouble(String.valueOf(p.getElement()));
        }
        return calc(String.valueOf(p.getElement()), getResult(p.getLeft()), getResult(p.getRight()));
    }

    // calculate a s b with a b is operand and s is operator
    public double calc(String s, double a, double b) {
        switch (s) {
        case "+":
            return a + b;
        case "-":
            return a - b;
        case "*":
            return a * b;
        case "/":
            return a / b;
        default:
            throw new IllegalArgumentException("error");
        }
    }

    // operand or operator
    public boolean check(String s) {
        switch (s) {
        case "+":
            return true;
        case "-":
            return true;
        case "*":
            return true;
        case "/":
            return true;
        default:
            return false;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ExpressionTree<String> eTree = new ExpressionTree<>();
        eTree.addRoot("*");

        eTree.addLeft(eTree.root(), "+");
        eTree.addLeft(eTree.root().getLeft(), "*");
        eTree.addLeft(eTree.root().getLeft().getLeft(), "6");
        eTree.addRight(eTree.root().getLeft().getLeft(), "3");
        eTree.addRight(eTree.root().getLeft(), "2");

        eTree.addRight(eTree.root(), "-");
        eTree.addLeft(eTree.root().getRight(), "7");
        eTree.addRight(eTree.root().getRight(), "4");

        System.out.print("Tiền tố: ");
        eTree.preorderPrint(eTree.root());
        System.out.println();

        System.out.print("Trung tố: ");
        eTree.inorderPrint(eTree.root());
        System.out.println();

        System.out.print("Hậu tố: ");
        eTree.postorderPrint(eTree.root());
        System.out.println();

        System.out.print("Giá trị biểu thức: " + eTree.getResult(eTree.root()));
    }
}
