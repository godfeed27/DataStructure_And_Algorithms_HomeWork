package hw3_19000243;

import java.util.Scanner;

public class Complex {
    static Scanner sc = new Scanner(System.in);

    double real, img;

    Complex(double r, double i) {
        this.real = r;
        this.img = i;
    }

    public static Complex inputComplex() {
        System.out.println("Nhap so phuc:");
        String input_string = sc.nextLine();
        try {
            String[] coef = input_string.split("i")[0].split("\\+");
            Complex k = new Complex(0, 0);
            k.real = Double.parseDouble(coef[0]);
            k.img = Double.parseDouble(coef[1]);
            return k;
        } catch (Exception numberFormatException) {
            String[] coef = input_string.split("i")[0].split("\\-");
            Complex k = new Complex(0, 0);
            k.real = Double.parseDouble(coef[0]);
            k.img = -Double.parseDouble(coef[1]);
            return k;
        }
    }

    public static Complex SumTwoComplex(Complex a, Complex b) {
        Complex temp = new Complex(0, 0);
        temp.real = a.real + b.real;
        temp.img = a.img + b.img;
        return temp;
    }

    public static Complex MultiTwoComplex(Complex a, Complex b) {
        Complex temp = new Complex(0, 0);
        temp.real = a.real * b.real - a.img * b.img;
        temp.img = a.img * b.real + b.img * a.real;
        return temp;
    }

    public static Complex SumAnyComplex(Complex[] a) {
        Complex temp = new Complex(0, 0);
        for(Complex k:a) {
            temp = SumTwoComplex(temp, k);
        }
        return temp;
    }

    public static Complex MultiAnyComplex(Complex[] a) {
        Complex temp = new Complex(1, 0);
        for(Complex k:a) {
            temp = MultiTwoComplex(temp, k);
        }
        return temp;
    }

    public static void PrintComplex(Complex k) {
        System.out.printf("%.1f+%.1fi\n", k.real, k.img);
    }

    public static void main(String[] args) {
        System.out.println("Nhap n:");
        int n = sc.nextInt();
        sc.nextLine();
        Complex[] arr = new Complex[n];
        for (int i = 0; i < n; i++) {
            arr[i] = inputComplex();
        }
        PrintComplex(SumAnyComplex(arr));
        sc.close();
    }
}
