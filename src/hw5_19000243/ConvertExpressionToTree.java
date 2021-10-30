package hw5_19000243;

import java.io.FileNotFoundException;
import java.util.Stack;

public class ConvertExpressionToTree {
    Stack<Node<String>> Operator; // contains operators
    Stack<Node<String>> Operand; // contains operands

    public ConvertExpressionToTree() {
        this.Operator = new Stack<>();
        this.Operand = new Stack<>();
    }

    // converting return root
    public Node<String> convert(String s) {
        String[] ss = s.split("");

        for (int i = 0; i < ss.length; i++) {

            // if operators
            if (classify(ss[i]) > 0) {
                
                // add directly
                if (ss[i].equals("(") || Operator.size() == 0 || classify(ss[i]) > classify(Operator.peek().getElement())) {
                    Node<String> node = new Node<>();
                    node.setElement(ss[i]);
                    Operator.push(node);
                    // catching ")"
                } 
                else if (ss[i].equals(")")) {
                    while (!Operator.peek().getElement().equals("(")) {
                        createTree();
                    }
                    Operator.pop();
                    // The operator under consideration has a lower coefficient than the top value in the operators
                } 
                else {
                    while (Operator.size() > 0) {
                        if (classify(ss[i]) <= classify(Operator.peek().getElement()))
                            createTree();
                    }
                    Node<String> node = new Node<>();
                    node.setElement(ss[i]);
                    Operator.push(node);
                }

                // if operands
            } 
            else {
                Node<String> node = new Node<>();
                node.setElement(ss[i]);
                Operand.push(node);
            }

        }
        // handling residual marks
        while (Operator.size() != 0) {
            createTree();
        }
        return Operand.pop();
    }

    // create a tree with 2 child as operands and 1 operator and add that operator to the operands
    public void createTree() {
        Operator.peek().setRight(Operand.pop());
        Operator.peek().setLeft(Operand.pop());
        Operand.push(Operator.pop());

    }

    // classify operator
    public int classify(String s) {
        if (s.equals("/") || s.equals("*")) {
            return 3;
        }
        else if (s.equals("+") || s.equals("-")) {
            return 2;
        }
        else if (s.equals("(") || s.equals(")")) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ConvertExpressionToTree cToTree = new ConvertExpressionToTree();
        String s = "5-3*(3-2)+7";
        ExpressionTree<String> eTree = new ExpressionTree<>();
        eTree.preorderPrint(cToTree.convert(s));
    }
}
