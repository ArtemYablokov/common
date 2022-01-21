package com.yabloko.primitives;

import java.util.Formatter;

import static java.lang.Integer.toBinaryString;

public class BitwiseLogic {
    public static void main(String[] args) {
        byte b2 = 0b0000_0010;
        byte b8 = 0b0000_1000;

        System.out.println(b2);
        System.out.println(b8);

        byte b2andb8 = (byte) (b2 + b8);
        System.out.println(toBinaryString(b2andb8));
        System.out.println(b2andb8);

        int p = 0b1000_0000_0000_0000_0000_0000_0000_0000;
        System.out.printf("%s = %d", toBinaryString(p), p);
        System.out.print("\n");
        int n = ~p/*0b1000_0000_0000_0000_0000_0000_0000_0000*/;
        System.out.printf("%s = %d", toBinaryString(n), n);
        System.out.print("\n");

        System.out.printf("MAX_VALUE = %s", toBinaryString(Integer.MAX_VALUE));
        System.out.print("\n");
        System.out.printf("MIN_VALUE = %s", toBinaryString(Integer.MIN_VALUE));
        System.out.print("\n");

        System.out.println(String.format("MAX_VALUE & MIN_VALUE = %s", toBinaryString(p & n))); // = 0
        System.out.println(String.format("MAX_VALUE | MIN_VALUE = %s", toBinaryString(p | n))); // 111...111 - 4х8 штук
        System.out.println(String.format("MAX_VALUE ^ MIN_VALUE = %s", toBinaryString(p ^ n))); // 111...111 - 4х8 штук




    }

    // метод "расширяет" до INT
    static void printBinary(String string, int value) {
        Formatter formatter = new Formatter();
        Formatter format = formatter.format(string + " = %s", toBinaryString(value));
        System.out.println(format.toString());
    }
}
