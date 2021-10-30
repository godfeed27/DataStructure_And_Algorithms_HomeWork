package hw5_19000243;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<Integer> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 128;

    public ArrayBinaryTree() throws FileNotFoundException {
        array = (E[]) new Object[defaultsize];
    }

    public E[] getArray() {
        return array;
    }

    public void setRoot(E element) {
        array[1] = element;
        n ++;
    }

    public void setLeft(int p, E element) {
        if (2 * p + 1 > defaultsize) {
            throw new IllegalArgumentException("full");
        }
        else {
            array[2 * p] = element;
            n ++;
        }
    }

    public void setRight(int p, E element) {
        if (2 * p + 1 > defaultsize) {
            throw new IllegalArgumentException("full");
        }
        else {
            array[2 * p + 1] = element;
            n ++;
        }
    }

    @Override
    public Integer root() {
        return 1;
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
    public int numChildren(Integer p) {
        int count = 2;
        if (2 * p >= defaultsize) {
            return 0;
        }
        if (array[p * 2] == null) {
            count --;
        }
        if (array[p * 2 + 1] == null) {
            count --;
        }
        return count;
    }

    @Override
    public Integer parent(Integer p) {
        return p / 2;
    }

    @Override
    public Integer left(Integer p) {
        return 2 * p;
    }

    @Override
    public Integer right(Integer p) {
        return 2 * p + 1;
    }

    @Override
    public Integer sibling(Integer p) {
        if (p == 1) {
            return null;
        }
        else if (p % 2 == 0) {
            return p + 1;
        }
        else {
            return p - 1;
        }
    }

    // use recursive to print subgraph of element p
    public void print(int p, BufferedOutputStream bufferOut) throws IOException {
        if (array[right(p)] != null) {
            print(2 * p + 1, bufferOut);
        }
        String value = Space(p) + array[p] + "\n";
        byte[] b = value.getBytes();
        bufferOut.write(b);
        bufferOut.flush();
        System.out.print(value);
        if (array[left(p)] != null) {
            print(2 * p, bufferOut);
        }
    }

    public String Space(int p) {
        int s = (int) Math.floor(Math.log(p) / Math.log(2));
        String space = "";
        for (int i = 0; i < 2 * s; i++) {
            space += "  ";
        }
        return space;
    }
}
