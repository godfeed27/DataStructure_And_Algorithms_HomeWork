package hw3_19000243;

public class SimpleLinkedList<T> {
    public class Node {
        T data;
        Node next;

        public Node(T data, SimpleLinkedList<T>.Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }

    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public Node getBot() {
        return bot;
    }

    public void setBot(Node bot) {
        this.bot = bot;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    // nếu list chưa có phần tử thì gán top = bot= node(data,nul)
    // nếu hàm có 1 phần tử gán bot = node(data,null) top.next = bot
    // 2 phần tử làm bình thg

    public void add(T data) {
        Node newNode = new Node(data, null);
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else if (top.equals(bot)) {
            newNode.next = bot;
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        n++;
    }

    public void addBot(T data) {
        Node newNode = new Node(data, null);
        if (top == null) {
            top = newNode;
            bot = newNode;
        } else if (top.equals(bot)) {
            top.next = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }

    public T get(int i) {
        Node resuit = top;
        for (int j = 1; j < i; j++) {
            resuit = resuit.next;
        }
        return resuit.data;
    }

    // Phương thức tìm ra index của phần tử đầu tiên có giá trị bằng data
    public int indexOf(T data) {
        Node resuit = top;
        int i = 0;
        while (resuit != null) {
            if (resuit.data.equals(data))
                return i;
            else {
                resuit = resuit.next;
                i++;
            }
        }
        return -1;
    }

    public void set(int i, T data) {
        Node extraNode = top;
        for (int j = 1; j < i; j++) {
            if (j == i - 1)
                extraNode.next.data = data;
            extraNode = extraNode.next;
        }

    }

    public boolean isContain(T data) {
        Node extraNode = top;
        while (extraNode != null) {
            if (extraNode.data.equals(data)) {
                return true;
            } else
                extraNode = extraNode.next;
        }
        return false;

    }

    public int size() {
        return n;

    }

    public boolean isEmpty() {

        if (n == 0)
            return false;
        return true;

    }

    public T removeTop() {
        Node extraNode = top;
        top = top.next;
        n--;
        return extraNode.data;
    }

    public T removeBot() {
        Node extraNode1 = top;
        Node extraNode2 = bot;
        while (true) {
            if (extraNode1.next.next.next == null) {
                bot = extraNode1.next;
                bot.next = null;
                break;
            }
            extraNode1 = extraNode1.next;
        }
        n--;
        return extraNode2.data;
    }

    // loại bỏ hết những giá trị đầu tiên bằng T để cố định 1 giá trị ban đầu là
    // chuẩn
    // chạy vòng lặp nếu kiểm tra phần tử cuối là T remove bot rồi break, nếu không thì kiểm tra
    // tiếp
    // ví dụ 3 phần tử a T b gán a.next = a.next.next(phần tử b)
    public void remove(T data) {
        while (top.data == data) {
            removeTop();
        }
        Node extraNode = top;
        while (extraNode != null) {
            if (extraNode.next.data == data) {
                if (extraNode.next.next == null) {
                    removeBot();
                    break;
                } else {
                    extraNode.next = extraNode.next.next;
                    n--;
                }

            } else
                extraNode = extraNode.next;
        }
    }

    public void print() {
        Node x = top;
        while (x != null) {
            System.out.print(x + " ");
            x = x.next;
        }
        System.out.println();
    }

    public Node getPrevious(Node node) {
        Node previous = top;
        while (node != null) {
            if (previous.next.equals(node))
                return previous;
            previous = previous.next;
        }
        return previous;
    }

    // sắp xếp lại mảng
    // sử dụng thuật toán nổi bọt
    public void sort() {
        for (int i = 0; i < n - 1; i++) {
            Node a = top;
            for (int j = 0; j < n - i - 1; j++) {
                if (Integer.compare((int) a.data, (int) a.next.data) > 0) {
                    if (a.equals(top)) {
                        Node b = a.next;
                        a.next = b.next;
                        b.next = a;
                        top = b;
                    } else if (a.next.equals(bot)) {
                        boolean check = false;
                        if (getPrevious(a).equals(top)) {
                            add(top.data);
                            check = true;
                        }
                        getPrevious(getPrevious(a)).next.next = bot;
                        bot.next = a;
                        a.next = null;
                        bot = a;
                        if (check) {
                            removeTop();
                        }
                    } else {
                        boolean check = false;
                        if (getPrevious(a).equals(top)) {
                            add(top.data);
                            check = true;
                        }
                        Node b = a.next;
                        getPrevious(getPrevious(a)).next.next = b;
                        a.next = b.next;
                        b.next = a;
                        if (check) {
                            removeTop();
                        }
                    }
                } else {
                    a = a.next;
                }

            }
        }
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> a = new SimpleLinkedList<>();
        Integer[] b = {1, 5, 2, 7, 10, 7, 4, 8, 5, 1, 4, 8, 8, 5};

        for (int i : b)
            a.add(i);
        System.out.print("Danh sách: ");
        a.print();

        System.out.print("Lấy ra phần tử thứ 5: ");
        System.out.println(a.get(5));

        System.out.println("Thay đổi giá trị phần tử thứ 6 là 3");
        a.set(5, 9);

        System.out.print("Danh sách: ");
        a.print();

        System.out.println("Có phần tử 3: " + a.isContain(9));

        System.out.println("Phần tử top là: " + a.removeTop());
        System.out.print("Danh sách sau khi xóa top: ");
        a.print();

        System.out.println("Phần tử bot là: " + a.removeBot());
        System.out.print("Danh sách sau khi xóa bot: ");

        a.print();
        a.sort();
        a.print();

    }
}
