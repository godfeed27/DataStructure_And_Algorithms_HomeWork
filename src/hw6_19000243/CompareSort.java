package hw6_19000243;

import java.util.Random;

public class CompareSort {

    // sắp xếp sử dụng heap
    public void heapSort(int[] arr) {
        long start = System.currentTimeMillis();

        int n = arr.length;
        MinHeapPriorityQueue<Integer, Integer> heap = new MinHeapPriorityQueue<>();
        for (int i = 0; i < n; i++) {
            heap.insert(arr[i], arr[i]);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = heap.removeMin().getKey();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time heapsort: " + (end - start));
    }

    // In ra mảng
    public static void print(int[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
            if (i == a.length - 1) {
                System.out.print(a[i]);
            }

        }
        System.out.println(" ]");
    }
    // sắp sếp chọn
    void selectionSort(int[] arr) {
        long start = System.currentTimeMillis();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        long end = System.currentTimeMillis();
        System.out.println("Time selectionsort: " + (end - start));
    }

    void quickSort(int[] a, int low, int high) {
        int pivotIndex;

        if (low < high) {
            pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex - 1);
            quickSort(a, pivotIndex + 1, high);
        }
    }

    // sắp xếp nhanh
    void quickSort(int[] a) {
        long start = System.currentTimeMillis();
        quickSort(a, 0, a.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("Time quicksort: " + (end - start));
    }

    int partition(int[] a, int i, int j) {
        int p = a[i];
        int m = i;
        for (int k = i + 1; k <= j; k++) {
            if (a[k] < p) {
                m++;
                swap(a, k, m);
            }
        }
        swap(a, i, m);
        return m;
    }

    void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    //sắp xếp chèn
    void mergeSort(int[] a) {
        long start = System.currentTimeMillis();
        mergeSort(a, 0, a.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("Time mergsort: " + (end - start));
    }

    // thao tác ghép 2 mảng sau khi tách
    void merge(int[] a, int low, int mid, int high) {
        int[] b = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int bIdx = 0;
        while (left <= mid && right <= high) {
            if (a[left] < a[right]) {
                b[bIdx++] = a[left++];
            } 
            else {
                b[bIdx++] = a[right++];
            }
        }
        while (left <= mid)
            b[bIdx++] = a[left++];
        while (right <= high)
            b[bIdx++] = a[right++];
        for (int i = 0; i < high - low + 1; i++) {
            a[low + i] = b[i];
        }
        b = null;
    }

    // đổi chỗ các phần tử
    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // tạo ra ngẫu nhiên 1 mảng n phần tử
    int[] giveInPut(int n) {
        int[] a = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int r = random.nextInt(5 * n);
            a[i] = r;
        }
        return a;
    }

    public static void main(String[] args) {
        // số lượng phàn tử
        int n = 1000;
        CompareSort compare = new CompareSort();
        int[] a = compare.giveInPut(n);
        int[] b=a.clone();
        compare.heapSort(b);
        b=a.clone();
        compare.selectionSort(b);
        b=a.clone();
        compare.mergeSort(b);
        b=a.clone();
        compare.quickSort(b);
    }
}
