package hw6_19000243;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            this.key = k;
            this.element = e;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public E getValue() {
            return element;
        }

        @Override
        public String toString() {
            return String.format("%-12s%-12d", element, key);
        }

    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 10000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultsize];

    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void insert(Entry<K, E> entry) {
        array[n] = new ArrEntry<K, E>(entry.getKey(), entry.getValue());
        n++;
    }

    @Override
    public void insert(K k, E e) {
        array[n] = new ArrEntry<K, E>(k, e);
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        int indexMin = 0;
        ArrEntry<K, E> min = array[0];
        for (int i = 0; i < n; i++) {
            if (array[indexMin].getKey().compareTo(array[i].key) == 1) {
                indexMin = i;
                min = array[i];
            }
        }
        for (int i = indexMin; i < n; i++) {
            array[i] = array[i + 1];
        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        int indexMin = 0;
        for (int i = 0; i < n; i++) {
            if (array[indexMin].getKey().compareTo(array[i].key) == 1) {
                indexMin = i;
            }
        }
        return array[indexMin];
    }

    public void print() {
        System.out.println("danh sách dữ liệu");
        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
        System.out.println("----------------");
    }

    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, String> arr = new UnsortedArrayPriorityQueue<>();
        arr.insert(5, "ti vi");
        arr.insert(10, "máy giặt");
        arr.insert(11, "tủ lạnh");
        arr.insert(1, "bút");
        arr.insert(3, "ti vi");
        arr.insert(5, "tủ");

        arr.print();

        System.out.println("Phần tử nhỏ nhất: " + arr.min());
        arr.print();

        System.out.println("Xóa phần tử nhỏ nhất: " + arr.removeMin());
        arr.print();

        System.out.println("Xóa phần tử nhỏ nhất: " + arr.removeMin());
        arr.print();

        System.out.println("Xóa phần tử nhỏ nhất: " + arr.removeMin());
        arr.print();

        System.out.println("Xóa phần tử nhỏ nhất: " + arr.removeMin());
        arr.print();
    }
}
