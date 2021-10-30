package hw5_19000243;

import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class PrintTree {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bufferOut = null;
        FileOutputStream outputStream;
        String OutputFile = "./src/hw5_19000243/output.txt";
        outputStream = new FileOutputStream(OutputFile);
        bufferOut = new BufferedOutputStream(outputStream);

        ArrayBinaryTree<Integer> a = new ArrayBinaryTree<>();
        a.setRoot(1);
        for (int i = 1; i <= 7; i ++) {
            a.setLeft(i, 2 * i);
            a.setRight(i, 2 * i + 1);
        }
        a.print(a.root(), bufferOut);

        System.out.println("-----------------\n\n");
        String line = "-----------------\n\n";
        byte[] lines = line.getBytes();
        bufferOut.write(lines);
        bufferOut.flush();

        LinkedBinaryTree<Integer> b = new LinkedBinaryTree<>();
        b.addRoot(1);
        b.addLeft(b.root(), 2);
        b.addRight(b.root(), 3);
        b.addLeft(b.root().getLeft(), 4);
        b.addRight(b.root().getLeft(), 5);
        b.addLeft(b.root().getRight(), 6);
        b.addRight(b.root().getRight(), 7);

        b.print(b.root(), "", bufferOut);
    }
}
