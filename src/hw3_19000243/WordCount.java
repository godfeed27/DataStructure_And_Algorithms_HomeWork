package hw3_19000243;

import java.util.Scanner;

public class WordCount {
    String word;
    int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public boolean equals(Object obj) {

        return word.equals(((WordCount) obj).word);
    }

    @Override
    public String toString() {
        return "WordCount [word=" + word + ", count=" + count + "], ";
    }

    public static void main(String[] args) {
        // danh sách những từ đọc từ văn bản
        SimpleArrayList<String> listWord = new SimpleArrayList<String>();

        // danh sách các từ xuất hiện và số lượng xuất hiện
        SimpleLinkedList<WordCount> listWordCount = new SimpleLinkedList<WordCount>();

        // nhập input và xử lí văn bản
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] list = text.split("\s");

        for (int i = 0; i < list.length; i++)
            listWord.add(list[i]);

        // thêm phẩn tử đầu tiên cố định
        listWordCount.add(new WordCount(listWord.get(1), 1));
        
        // duyệt từng từ trong listword nếu đã xuất hiện +1 vào số lượng từ đó trong
        // listwordcount nếu ko thêm từ đó với số lượng 1
        for (int i = 2; i < listWord.size(); i++) {
            WordCount wd = new WordCount(listWord.get(i), 1);
            if (listWordCount.isContain(wd)) {
                int index = listWordCount.indexOf(wd);
                WordCount resuit = listWordCount.get(index);
                resuit.count++;
                listWordCount.set(index, resuit);
            } else {
                listWordCount.addBot(wd);
            }
        }
        listWordCount.print();
        sc.close();
    }
}