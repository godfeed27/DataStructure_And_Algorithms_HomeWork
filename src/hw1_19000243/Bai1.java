package hw1_19000243;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập boolean: ");
        boolean a1 = sc.nextBoolean();
        System.out.println("In ra kiểu boolean: " + a1);

        System.out.print("Nhập byte: ");
        byte a2 = sc.nextByte();
        System.out.println("In ra kiểu byte: " + a2);

        System.out.print("Nhập short: ");
        short a3 = sc.nextShort();
        System.out.println("In ra kiểu short: " + a3);

        System.out.print("Nhập long: ");
        long a4 = sc.nextLong();
        System.out.println("In ra kiểu long: " + a4);

        System.out.print("Nhập int: ");
        int a5 = sc.nextInt();
        System.out.println("In ra kiểu int: " + a5);

        System.out.print("Nhập float: ");
        float a6 = sc.nextFloat();
        System.out.println("In ra kiểu short: " + a6);

        System.out.print("Nhập double: ");
        double a7 = sc.nextDouble();
        System.out.println("In ra kiểu short: " + a7);

        System.out.print("Nhập xâu kí tự: ");
        String a8 = sc.nextLine();
        System.out.println("In ra kiểu short: " + a8);

        sc.close();
    }
}
