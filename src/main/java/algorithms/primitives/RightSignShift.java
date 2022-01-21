package com.yabloko.primitives;

import static com.yabloko.primitives.BitwiseIntShift.*;
import static com.yabloko.primitives.BitwiseLogic.printBinary;

public class RightSignShift {
    public static void main(String[] args) {
        int integer = 0b1111_1111; // 255
        int integerNegative = 0b1111_1111_1111_1111_1111_1111_0000_0001; // -255

        System.out.println("integer " + integer);
        printBinary("integer ", integer);

        System.out.println("integerNegative " + integerNegative);
        printBinary("integerNegative ", integerNegative);


        /*
        * для ПОЛОЖИТЕЛЬНОГО ЧИСЛА НЕТ РАЗНИЦЫ - перенос со знаком или без!
        * */
//        System.out.println("POSITIVE");
//        System.out.println("<<");
//        multiplyTwice(integer, 10);
//        System.out.println(">>");
//        divideTwice(integer, 10);
//        System.out.println(">>>");
//        divideTwiceWithSign(integer, 11);


        System.out.println("NEGATIVE");
        System.out.println("<<");
        multiplyTwice(integerNegative, 40);

        /*
         * сохраняет ЗНАК ВСЕГДА
         * */
        System.out.println(">>");
        divideTwice(integerNegative, 40);

        /*
        * сразу утрачивает ЗНАК !!!! - переводит в положительное  !!!
        * */
        System.out.println(">>>");
        divideTwiceWithSign(integerNegative, 40);


    }
}
