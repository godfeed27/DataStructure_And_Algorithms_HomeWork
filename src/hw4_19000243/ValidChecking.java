package hw4_19000243;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidChecking {

    static boolean ValidCheck(String input) {
        int countLeftParentheses = 0;
        int countRightParentheses = 0;

        if (input.charAt(0) == ')' || input.charAt(input.length() - 1) == '(') {
            return false;
        }

        for (int i = 0; i < input.length() - 1; i++) {
            if (OperandOrOperator(input.charAt(i)) * OperandOrOperator(input.charAt(i + 1)) == 4) {
                return false;
            } 
            else if (OperandOrOperator(input.charAt(i)) * OperandOrOperator(input.charAt(i + 1)) == 2) {
                int s = 2;
                int j = i + 2;

                while (s == 2 && j < input.length()) {
                    s *= OperandOrOperator(input.charAt(j));
                    if (s == 4) {
                        return false;
                    }
                    j++;
                }
            }
            if (input.charAt(i) == '(') {
                countLeftParentheses++;
            }
            if (input.charAt(i) == ')'){
                countRightParentheses++;
            }
        }

        if (input.charAt(input.length() - 1) == ')') {
            countRightParentheses++;
        }
        if (countRightParentheses != countLeftParentheses) {
            return false;
        }
        return true;
    }

    static double ComputeValue(ArrayList<String> arr) {
        LinkedListStack<Double> OperandStack = new LinkedListStack<>();
        LinkedListStack<String> OperatorStack = new LinkedListStack<>();

        for (int i = 0; i < arr.size(); i++) {
            if (OperandOrOperator(arr.get(i).charAt(0)) == 0) {
                OperandStack.push(Double.parseDouble(arr.get(i)));
            } 
            else if (OperandOrOperator(arr.get(i).charAt(0)) == 2) {
                if (OperatorStack.isEmpty()) {
                    OperatorStack.push(arr.get(i));
                } 
                else if (Priority(arr.get(i).charAt(0)) > Priority(OperatorStack.top().charAt(0)) || OperatorStack.top() == "(") {
                    OperatorStack.push(arr.get(i));
                } 
                else {
                    double b = OperandStack.pop();
                    double a = OperandStack.pop();
                    String x = OperatorStack.pop();
                    OperandStack.push(Compute(a, b, x));
                    if (Priority(arr.get(i).charAt(0)) <= Priority(OperatorStack.top().charAt(0))) {
                        b = OperandStack.pop();
                        a = OperandStack.pop();
                        x = OperatorStack.pop();
                        OperandStack.push(Compute(a, b, x));
                    }
                    OperatorStack.push(arr.get(i));
                }
            } 
            else {
                if (arr.get(i).equals("("))
                    OperatorStack.push("(");
                else {
                    while (!OperatorStack.top().equals("(") || Priority(arr.get(i).charAt(0)) > Priority(OperatorStack.top().charAt(0))) {
                        double b = OperandStack.pop();
                        double a = OperandStack.pop();
                        String x = OperatorStack.pop();
                        OperandStack.push(Compute(a, b, x));
                    }
                    OperatorStack.pop();
                }

            }
        }

        while (!OperatorStack.isEmpty()) {
            double b = OperandStack.pop();
            double a = OperandStack.pop();
            String x = OperatorStack.pop();
            OperandStack.push(Compute(a, b, x));
        }
        return OperandStack.top();
    }

    static double Compute(double a, double b, String x) {
        if (x.equals("*")) {
            return a * b;
        }
        else if (x.equals("+")) {
            return a + b;
        }
        else if (x.equals("/")) {
            return a / b;
        }
        else if (x.equals("-")) {
            return a - b;
        }
        else {
            return Math.pow(a, b);
        }
    }

    static int Priority(char x) {
        if (x == '^') {
            return 3;
        }
        if (x == '*' || x == '/' || x == '%' || x == '^') {
            return 2;
        }
        else if (x == '+' || x == '-') {
            return 1;
        }
        else if (x == '(' || x == ')') {
            return 0;
        }
        return -1;
    }

    static int OperandOrOperator(char x) {
        if (x == '*' || x == '/' || x == '%' || x == '^' || x == '+' || x == '-') {
            return 2;
        }
        else if (x == '(' || x == ')') {
            return 1;
        }
        else {
            return 0;
        }
    }

    static ArrayList<String> split(String a) {
        ArrayList<String> b = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            if (OperandOrOperator(a.charAt(i)) != 0)
                b.add(String.valueOf(a.charAt(i)));
            else {
                String x = String.valueOf(a.charAt(i));
                if (i == a.length() - 1) {
                    b.add(x);
                    break;
                }
                int j = i + 1;
                while (OperandOrOperator(a.charAt(j)) == 0) {
                    x += String.valueOf(a.charAt(j));
                    i++;
                    j++;
                    if (j == a.length())
                        break;
                }
                b.add(x);
            }
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String a = sc.nextLine();
        String a = "2-3*(5+3)-2^5";
        String b = "((2+5)+6*7))";
        String c = "100/((2+5)*2-4)^2";
        sc.close();
        System.out.println("Expression a: " + ValidCheck(a));
        ArrayList<String> x = split(a);
        System.out.println("Expression Value: " + ComputeValue(x));
        System.out.println("Expression c: " + ValidCheck(c));
        ArrayList<String> y = split(c);
        System.out.println("Expression Value: " + ComputeValue(y));
        System.out.println("Expression b: " + ValidCheck(b));
    }
}
