package hw3_19000243;

import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        // nếu số phần tử có giá trị = kích thước mảng thì khi đó gấp đôi kích thước
        // mảng
        // nếu ko thì thêm phần tử thứ n+1 như bình thường
        if (n == array.length) {
            T[] extraArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                extraArray[i] = array[i];
            }
            extraArray[n] = data;
            array = extraArray;
            n++;
        } else {
            array[n] = data;
            n++;
        }
    }

    public T get(int i) {
        return array[i];
    }

    public void set(int i, T data) {
        array[i] = data;
    }

    // tạo ra mảng mới không chứa data
    public void remove(T data) {
        int count = 0;
        T[] extraArray = (T[]) new Object[n];
        for (int i = 0; i < n; i++) {
            if (array[i] != data) {
                extraArray[count] = array[i];
                count++;
            }

        }
        array = extraArray;
        n = count;
    }

    public boolean isContain(T data) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        if (n == 0)
            return true;
        else
            return false;
    }

    public Iterator<T> iterator() {

        return null;
    }

    // hàm in mảng
    void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(array[i].toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SimpleArrayList<Integer> a = new SimpleArrayList<Integer>();

        // tạo 1 mảng số và thực hiện các phương thức
        Integer[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : b) {
            a.add(i);
        }
        a.print();
        a.remove(9);
        a.print();
        System.out.println(a.get(0));
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println(a.isContain(15));
    }

}
