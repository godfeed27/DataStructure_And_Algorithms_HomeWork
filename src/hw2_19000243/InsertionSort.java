package hw2_19000243;

import java.util.Scanner;

public class InsertionSort {
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
        // Duyệt qua từng phần tử của mảng (bắt đầu từ vị trí thứ 2)
        for (int i = 1; i < arr.length; ++i) {
            // Đặt hasSwap thành false
            hasSwap = false;
            // Chọn phần tử thứ i làm key
            int key = arr[i];
            // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    // Nếu mọi phần tử đằng trước đều nhỏ hơn key thì hasSwap giữ nguyên là false
                    hasSwap = true;
                }
                // Tăng số lần so sánh
                compareCount++;
                // Giảm j
                j--;
            }
            // Kiểm tra hasSwap, nếu có thì chèn key và tăng số lần đổi chỗ và in ra dãy sau khi đổi
            if (hasSwap) {
                arr[j + 1] = key;
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
