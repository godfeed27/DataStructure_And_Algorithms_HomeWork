package hw1_19000243;

import java.util.Scanner;

public class Array_2 {
    static Scanner sc = new Scanner(System.in);
    
    static void InputNumber(int[] numbers) {
        System.out.println("Nhập n số: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
    }

    public static boolean IsPerfect(int k) {
        int sum = 0;
        for (int i = 1; i <= k / 2; i++) {
            if(k % i == 0) 
              sum += i;
        }
        if (sum == k) {
            return true;
        }
        else {
            return false;
        }
    }

    static void PrintPerfectNumbers(int[] numbers) {
        for (int i : numbers) {
            if (IsPerfect(i) && i != 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];
        InputNumber(numbers);
        System.out.print("Số hoàn hảo: ");
        PrintPerfectNumbers(numbers);
    }
}
