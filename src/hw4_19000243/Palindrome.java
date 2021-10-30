package hw4_19000243;

public class Palindrome {
    ArrayQueue<String> spilitQueue(String[] a) {
        ArrayQueue<String> word = new ArrayQueue<>();
        for (String s : a) {
            word.enqueue(s);
        }
        return word;
    }

    ArrayStack<String> spilitStack(String[] a) {
        ArrayStack<String> word = new ArrayStack<>();
        for (String s : a) {
            word.push(s);
        }
        return word;
    }

    boolean isPalindrome(ArrayQueue<String> queue, ArrayStack<String> stack) {
        for (int i = 0; i < stack.size(); i++) {
            if (!queue.dequeue().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "HOhgghOH";
        String[] b = a.split("");
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(palindrome.spilitQueue(b), palindrome.spilitStack(b)));
    }
}
