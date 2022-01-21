package com.yabloko.primitives;

import static com.yabloko.primitives.BitwiseLogic.printBinary;
import static java.lang.Integer.toBinaryString;



public class BitwiseByteShift {
    public static void main(String[] args) {

        byte b1 = 0b1;
        byte b2 = 0b0000_0010;
        byte b8 = 0b0000_1000;
        byte b67 = 0b0100_0011;

        byte b8Neg = -0b0000_1000;
        byte b67Neg = -0b0100_0011;

        printBinary("b2", b2);
        printBinary("b8", b8);

        /*
        * ЛЕВОЕ СМЕЩЕНИЕ
        * каким то образом после полного круга в 32 бита компилятор восстанавливает справа последовательность битов:
        * здесь не важно сохранение знака - просто ползут байты конвеером влево
        *
        * */
        System.out.println("ЛЕВОЕ СМЕЩЕНИЕ");
        System.out.println("смещение левое << проходит полный цикл = умножение на 2 ");

        System.out.println("байт 1  ");
        multiplyTwice(b1, 36);

        System.out.println("байт 8  ");
        multiplyTwice(b8, 36);

        System.out.println("байт 67  ");
        multiplyTwice(b67, 36);

        /*
         * ПРАВОЕ СМЕЩЕНИЕ
         * каким то образом после полного круга в 32 бита
         *  компилятор восстанавливает справа последовательность битов:
         *  для единицы просто отображает единицу (раз в 32 шага) ???
         *  для 8 соответственно справа вылезает 1000 потом 100 потом 10 потом 1 потом 0 (32-4 раза)
         *
         * РАБОТАЕТ ВЕРНО !
         *  НЕ дополняет старшие биты ЕДИНИЙАМИ
         *  */
        System.out.println("ПРАВОЕ СМЕЩЕНИЕ");
        System.out.println("смещение правое >>  = деление на 2 ");

        System.out.println("байт 1  ");
        divideTwice(b1, 36);

        System.out.println("байт 8  ");
        divideTwice(b8, 36);

        System.out.println("байт 67  ");
        divideTwice(b67, 36);

        /*
         * СОМНИТЕЛЬНОЕ ЗАНЯТИЕ ПРАВОЕ СМЕЩЕНИЕ со знаком  для ОТРИЦАТЕЛЬНОГО ЧИСЛА  !!!
         * сразу переходит в Int (дополняет старшие биты ЕДИНИцАМИ) - и производит деление на 2
         * однако через 32 цикла повторяет точный результат
         *
-8>>>30 = 11
3
-8>>>31 = 1
1
-8>>>32 = 11111111111111111111111111111000
-8
-8>>>33 = 1111111111111111111111111111100
2147483644
-8>>>34 = 111111111111111111111111111110
1073741822
         *
         *
         * */

        System.out.println("ПРАВОЕ СМЕЩЕНИЕ со знаком");
        System.out.println("смещение правое >>>  = деление на 2 ");

        System.out.println("байт 8  ");
        divideTwiceWithSign(b8, 36);

        System.out.println("байт -67  ");
        divideTwiceWithSign(b67Neg, 36);
    }

    private static void divideTwice(byte val, int times) {
        for (int i = 0; i < times; i++) {
            printBinary(val + ">>" + i, val>>i);
            System.out.println(val>>i);

        }
    }

    static void divideTwiceWithSign(byte val, int times) {
        for (int i = 0; i < times; i++) {
            printBinary(val + ">>>" + i, val>>>i);
            System.out.println(val>>>i);
        }
    }

    static void multiplyTwice(byte val, int times) {
        for (int i = 0; i < times; i++) {
            printBinary(val + "<<" + i, val<<i);
            System.out.println(val<<i);
        }
    }


}