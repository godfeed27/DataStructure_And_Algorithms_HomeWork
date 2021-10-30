package hw1_19000243;

import java.util.Random;

public class BirthdayParadox {
    static Random rand = new Random();
    public static void main(String[] args) {
        int n = 5;
        while (n <= 100) {
            System.out.println("Với n= " + n);

            int[] birthdays = new int[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                birthdays[i] = rand.nextInt(365)+1;;
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (birthdays[i] == birthdays[j]) {
                        count++;
                    }
                }
            }
            System.out.println("Số cặp trùng nhau là: " + count);
            System.out.println("Tỉ lệ: " + (double) count / (n * (n - 1)));
            System.out.println();
            n += 5;
        }
    }
}