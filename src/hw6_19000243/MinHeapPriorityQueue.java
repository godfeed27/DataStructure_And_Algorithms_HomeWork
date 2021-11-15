package hw6_19000243;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E> {
    ArrEntry<K, E> heapPQ[];

    public MinHeapPriorityQueue() {
        heapPQ = new ArrEntry[defaultsize];
    }

    @Override
    public void insert(Entry<K, E> entry) {
        if (n == 0) {
            heapPQ[n + 1] = new ArrEntry<K, E>(entry.getKey(), entry.getValue());
            n++;
        } 
        else {
            heapPQ[n + 1] = new ArrEntry<K, E>(entry.getKey(), entry.getValue());
            n++;
            upHeap();
        }
    }

    @Override
    public void insert(K k, E e) {
        if (n == 0) {
            heapPQ[n + 1] = new ArrEntry<K, E>(k, e);
            n++;
        } 
        else {
            heapPQ[n + 1] = new ArrEntry<K, E>(k, e);
            n++;
            upHeap();
        }
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Entry<K, E> min() {
        return heapPQ[1];
    }

    @Override
    public Entry<K, E> removeMin() {
        ArrEntry<K, E> min = heapPQ[1];
        swap(1, n);
        n--;
        downHeap();
        return min;
    }

    @Override
    public int size() {
        return super.size();
    }

    // Các phương thức bổ sung

    // vun lên
    protected void upHeap() {
        int index = n;
        while (index > 1) {
            if (heapPQ[index].getKey().compareTo(heapPQ[index / 2].getKey()) == -1) {
                swap(index, index / 2);
                index = index / 2;
            } 
            else {
                break;
            }
        }
    }

    // đổi chỗ 2 phần tử trong mảng
    protected void swap(int i, int j) {
        ArrEntry<K, E> temp = new ArrEntry<K, E>(heapPQ[i].getKey(), heapPQ[i].getValue());
        heapPQ[i] = new ArrEntry<K, E>(heapPQ[j].getKey(), heapPQ[j].getValue());
        heapPQ[j] = new ArrEntry<K, E>(temp.getKey(), temp.getValue());
    }

    // vun xuống
    protected void downHeap() {
        int index = 1;

        while (index < n) {
            if (2 * index + 1 <= n) {

                if (heapPQ[index].getKey().compareTo(heapPQ[2 * index].getKey()) == -1 && heapPQ[index].getKey().compareTo(heapPQ[2 * index + 1].getKey()) == -1) {
                    break;
                } 
                else {
                    int min = 2 * index;
                    if (heapPQ[2 * index].getKey().compareTo(heapPQ[2 * index + 1].getKey()) == 1) {
                        min = 2 * index + 1;
                    }
                    swap(min, index);
                    index = min;
                }
            } 
            else {
                if (2 * index <= n && heapPQ[index].getKey().compareTo(heapPQ[2 * index].getKey()) == 1) {
                    swap(index, 2 * index);
                }
                break;
            }
        }
    }

    // in ra cây
    public void print(int i, String s) {
        if (n == 0) {
            return;
        }
        if (2 * i + 1 <= n) {
            print(2 * i + 1, s + "\t\t");
        }
        System.out.println(s + heapPQ[i].key + "-" + heapPQ[i].element);
        System.out.println();
        if (2 * i <= n) {
            print(2 * i, s + "\t\t");
        }
    }

    public void print() {
        System.out.println("danh sách phần tử theo key: ");
        print(1, "");
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, String> arr = new MinHeapPriorityQueue<>();
        arr.insert(5, "ti vi");
        arr.insert(10, "máy giặt");

        arr.insert(1, "bút");

        arr.insert(20, "đệm");
        arr.insert(8, "ti vi");

        arr.insert(2, "gối");

        arr.insert(5, "tủ");
        arr.insert(3, "chăn");
        arr.insert(3, "chiếu");

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

        System.out.println("Xóa phần tử nhỏ nhất: " + arr.removeMin());
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
