package main.java.yandex2;

import java.util.Scanner;

class Integral {
    public static double f(double x) {
        return (-3 * x * x + 2 * x + 9);
    }

    public static double I(double a, double b, int n, double y) {
        return ((b - a) / (2 * n) * y);
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n;
        double a, b, dy, In, y = 0;
        a = in.nextDouble();
        b = in.nextDouble();
        n = in.nextInt();
        if (n > 1) {
            dy = (b - a) / n;
            y += f(a) + f(b);
            for (int i = 1; i < n; i++) {
                y += 2 * (f(a + dy * i));
            }
            In = I(a, b, n, y);
            System.out.printf("%f", In);
        } else {
            System.out.printf("Wrong Data");
        }
    }
}
