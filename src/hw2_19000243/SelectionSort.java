package hw2_19000243;

import java.util.Scanner;

public class SelectionSort {
    static Scanner sc = new Scanner(System.in);

    public static void inputArr(int[] arr) {
        System.out.println("Nhập n số: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void Sort(int[] arr) {
        int swapCount = 0;
        int compareCount = 0;
        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < arr.length - 1; i++) {
            // Tìm phần tử nhỏ nhất tính từ phần tử thứ i
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
                // Mỗi vòng lặp là 1 lần so sánh
                compareCount++;
            }
            if (arr[min_idx] < arr[i]) {
                // Hoán đổi phần tử nhỏ nhất và phần tử thứ i
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
                // Tăng số lần đổi chỗ
                swapCount++;
                // In ra mảng sau khi đổi chỗ 2 phần tử
                printArr(arr);
            }
        }
        // In ra số lần so sánh và số lần đổi chỗ
        System.out.println("Só lần so sánh:" + compareCount);
        System.out.println("Số lần đổi chỗ:" + swapCount);
    }

    public static void printArr(int[] arr) {
        for (int i:arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("Nhập n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        inputArr(arr);
        Sort(arr);
        printArr(arr);
    }
}
