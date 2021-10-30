package hw2_19000243;

import java.util.Scanner;

public class BubbleSort {
    static Scanner sc = new Scanner(System.in);

    public static void inputArr(int[] arr) {
        System.out.println("Nhập n số: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static void Sort(int[] arr) {
        boolean hasSwap = false;
        int swapCount = 0;
        int compareCount = 0;
        // Quay lại từ đầu mảng và tiếp tục duyệt từng cặp
        for (int i = 0; i < arr.length-1; i++) {
            // Dùng biến hasSwap để thoát vòng lặp khi mảng đã được sắp xếp
            hasSwap = false;
            // Duyệt qua từng cặp 2 phần tử của mảng chưa được sắp xếp
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // Đổi chỗ 2 phần tử
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // Thay đổi biến hasSwap thành true vì có sự đổi chỗ, tăng số lần đổi chỗ
                    hasSwap = true;
                    swapCount++;
                    // In ra mảng sau khi đổi chỗ 2 phần tử
                    printArr(arr);
                }
                // Mỗi lần duyệt 1 cặp là 1 lần so sánh
                compareCount++;
            }
            // Kiểm tra vòng lặp vừa rồi có sự đổi chỗ nào hay không để thoát sớm vòng lặp
            if (!hasSwap) {
                break;
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
