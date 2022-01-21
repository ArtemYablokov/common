package com.yabloko.primitives;

import static com.yabloko.primitives.BitwiseLogic.printBinary;

/*
* int integer = Byte.MIN_VALUE;
        System.out.println(integer); //= -128 КАК БЕЗ ПРИВЕДЕНИЯ КОМПИЛЯТОР САМ ОБРЕЗАЕТ ДО БАЙТ ???
* */

public class ByteMin {
    public static void main(String[] args) {
        /*
        * по факту идет присвоение INT к BYTE
        * - поэтому значение 0b1000_0000 = 2^7 = 128
        * Это не входит в диапазон БИТА = -128 127
        * поэтому мы не можем присвоить это значение БАЙТУ - только INT
        * */

        int byteMin = 0b1000_0000;
        System.out.println(byteMin); // 128
        printBinary(" 0b1000_0000" , byteMin); // 10000000

        byte byteCast = (byte) byteMin;  // при явном приведении получим -128
        System.out.println(byteCast); // -128

        System.out.println("Integer.toBinaryString");
        printBinary("Byte.MAX_VALUE", Byte.MAX_VALUE); // 1111111
        printBinary("Byte.MIN_VALUE", Byte.MIN_VALUE); // 11111111111111111111111110000000

        int integer = Byte.MIN_VALUE;
        System.out.println(integer); // -128 КАК БЕЗ ПРИВЕДЕНИЯ КОМПИЛЯТОР САМ ОБРЕЗАЕТ ДО БАЙТ ???
        printBinary("Byte.MIN_VALUE", integer); // 11111111111111111111111110000000


//        byte bNeg128 = 0b1000_0000;
//        for (int i = 0; i < 33; i++) {
//            printBinary("bNeg128>>>", bNeg127 >>> i);
//            System.out.println(bNeg127 >>> i);
//        }

        int n = 129/*0b1111_1111*/;
        System.out.println(n & 0b1111_1111);

        byte b = (byte) n /*0b0111_1111*/;
        System.out.println(Integer.toBinaryString(b  /* & 0b1111_1111*/));

    }
}
