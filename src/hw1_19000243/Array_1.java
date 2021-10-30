package hw1_19000243;

import java.util.Scanner;

public class Array_1 {
    static Scanner sc = new Scanner(System.in);
    
    static void InputNumber(int[] numbers) {
        System.out.println("Nhập n số: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
    }

    public static boolean IsPrime(int k) {
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void PrintPrimeNumbers(int[] numbers) {
        for (int i : numbers) {
            if (IsPrime(i) && i != 1)
                System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];
        InputNumber(numbers);
        System.out.print("Số nguyên tố: ");
        PrintPrimeNumbers(numbers);
    }
}
