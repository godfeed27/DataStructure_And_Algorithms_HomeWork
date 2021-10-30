package hw2_19000243;

// Bài 4+5
public class GenericSort<T extends Comparable<T>> {
    T[] array;

    public GenericSort(T[] array) {
        this.array = array;
    }

    // Sắp xếp nổi bọt
    public T[] bubbleSort() {
        T[] arr = this.array;
        boolean hasSwap = false;
        int swapCount = 0;
        int compareCount = 0;
        // Quay lại từ đầu mảng và tiếp tục duyệt từng cặp
        for (int i = 0; i < arr.length-1; i++) {
            // Dùng biến hasSwap để thoát vòng lặp khi mảng đã được sắp xếp
            hasSwap = false;
            // Duyệt qua từng cặp 2 phần tử của mảng chưa được sắp xếp
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) == 1) {
                    // Đổi chỗ 2 phần tử
                    T temp = arr[j];
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
        return arr;
    }

    // Sắp xếp chọn
    public T[] selectionSort() {
        T[] arr = this.array;
        int swapCount = 0;
        int compareCount = 0;
        // Duyệt qua từng phần tử của mảng
        for (int i = 0; i < arr.length - 1; i++) {
            // Tìm phần tử nhỏ nhất tính từ phần tử thứ i
            int min_idx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min_idx]) == 1)
                    min_idx = j;
                // Mỗi vòng lặp là 1 lần so sánh
                compareCount++;
            }
            if (arr[min_idx].compareTo(arr[i]) == 0) {
                // Hoán đổi phần tử nhỏ nhất và phần tử thứ i
                T temp = arr[min_idx];
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
        return arr;
    }

    // Sắp xếp chèn
    public T[] insertionSort() {
        T[] arr = this.array;
        boolean hasSwap = false;
        int swapCount = 0;
        int compareCount = 0;
        // Duyệt qua từng phần tử của mảng (bắt đầu từ vị trí thứ 2)
        for (int i = 1; i < arr.length; ++i) {
            // Đặt hasSwap thành false
            hasSwap = false;
            // Chọn phần tử thứ i làm key
            T key = arr[i];
            // Di chuyển các phần tử của arr [0 ... i - 1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            int j = i - 1;
            while (j >= 0) {
                if (arr[j].compareTo(key) == 1) {
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
        return arr;
    }

    // in mảng
    public void printArr(T[] arr) {
        for (T i:arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] array = {0, 1, 2, 4, 5, 6, 8, 10, 50};
        GenericSort<Integer> genericSort = new GenericSort<Integer>(array);
        System.out.println("Sắp xếp nổi bọt: ");
        genericSort.printArr(genericSort.bubbleSort());
        System.out.println("Sắp xếp chèn: ");
        genericSort.printArr(genericSort.insertionSort());
        System.out.println("Sắp xếp nổi chọn: ");
        genericSort.printArr(genericSort.selectionSort());
    }
}
