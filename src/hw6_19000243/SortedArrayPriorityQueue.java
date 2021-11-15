package hw6_19000243;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {
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

        public void setKey(K key) {
            this.key = key;
        }

        public void setElement(E element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return String.format("%-12s%-12d", element, key);
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultsize = 10000;

    public SortedArrayPriorityQueue() {
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
        int index = n;
        while (array[index].key.compareTo(array[index - 1].key) == 1) {
            K key = array[index].key;
            E element = array[index].element;
            array[index].setKey(array[index - 1].key);
            array[index].setElement(array[index - 1].element);
            array[index - 1].setKey(key);
            array[index - 1].setElement(element);
            index--;
            if (index == -1) {
                break;
            }
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        array[n] = new ArrEntry<K, E>(k, e);
        int index = n;
        if (n == 0) {
            n++;
        }
        else {
            while (array[index].key.compareTo(array[index - 1].key) == -1) {
                K key = array[index].key;
                E element = array[index].element;
                array[index].setKey(array[index - 1].key);
                array[index].setElement(array[index - 1].element);
                array[index - 1].setKey(key);
                array[index - 1].setElement(element);
                index--;
                if (index == 0) {
                    break;
                }
            }
            n++;
        }
    }

    @Override
    public Entry<K, E> removeMin() {
        Entry<K, E> min = array[0];
        n--;
        int index = 0;
        while (index < n) {
            array[index].setKey(array[index + 1].key);
            array[index].setElement(array[index + 1].element);
            index++;
        }
        array[n] = null;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        return array[0];
    }

    public void print() {
        System.out.println("danh sách dữ liệu");
        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
        System.out.println("----------------");
    }

    public static void main(String[] args) {
        SortedArrayPriorityQueue<Integer, String> arr = new SortedArrayPriorityQueue<>();
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
