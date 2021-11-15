package hw6_19000243;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;

        public NodeEntry(K k, E e) {
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

        public NodeEntry<K, E> next() {
            return next;
        }

        public void setNext(NodeEntry<K, E> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return String.format("%-12s%-12d", element, key);
        }

    }

    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    // thêm vào đầu
    @Override
    public void insert(Entry<K, E> entry) {
        if (n == 0) {
            head = new NodeEntry<K, E>(entry.getKey(), entry.getValue());
            tail = new NodeEntry<K, E>(entry.getKey(), entry.getValue());
        } 
        else if (n == 1) {
            head = new NodeEntry<K, E>(entry.getKey(), entry.getValue());
            head.next = tail;
        } 
        else {
            NodeEntry<K, E> node = new NodeEntry<K, E>(entry.getKey(), entry.getValue());
            node.next = head;
            head = node;
        }
        n++;
    }

    @Override
    public void insert(K k, E e) {
        if (n == 0) {
            head = new NodeEntry<K, E>(k, e);
            tail = new NodeEntry<K, E>(k, e);
        } 
        else if (n == 1) {
            head = new NodeEntry<K, E>(k, e);
            head.next = tail;
        } 
        else {
            NodeEntry<K, E> node = new NodeEntry<K, E>(k, e);
            node.next = head;
            head = node;
        }
        n++;
    }

    @Override
    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        NodeEntry<K, E> node = head;
        NodeEntry<K, E> min = head;
        while (node != null) {
            if (min.key.compareTo(node.key) == 1) {
                min = node;
            }
            node = node.next;
        }
        node = head;

        // min là head
        if (node.key.compareTo(min.key) == 0) {
            head = head.next;
        } 
        else {
            while (node.next != null) {
                if (node.next.key.compareTo(min.key) == 0) {
                    node.next = node.next.next;
                    break;
                }
                node = node.next;
            }

        }
        n--;
        return min;
    }

    @Override
    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        NodeEntry<K, E> node = head;
        NodeEntry<K, E> min = head;
        while (node != null) {
            if (min.key.compareTo(node.key) == 1)
                min = node;
            node = node.next;
        }
        return min;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("no data");
            return;
        }
        System.out.println("danh sách dữ liệu");
        NodeEntry<K, E> node = head;
        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
        System.out.println("----------------");

    }

    public static void main(String[] args) {
        UnsortedLinkedPriorityQueue<Integer, String> arr = new UnsortedLinkedPriorityQueue<>();
        System.out.println("bat dau");
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
