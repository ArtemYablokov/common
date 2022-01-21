package com.yabloko.arrays;

import java.io.*;
import java.util.Arrays;

public class TwoDimensions {
    public static void main(String[] args) {
        Long[] longs = new Long[1];
        System.out.println(longs.getClass()); // class [Ljava.lang.Long;

        Object[][] ints = new Object[4][];
        System.out.println(ints.length);
        ints[0] = new Object[]{0,0};
        ints[1] = new Object[]{1,2,3,null};
        for (int i = 0; i < 4; i++) {

            System.out.println(ints[1][i]);
        }
        int n = 1;
        assert n < 0 : "err" ;

        char ch = 65535%65438;
        System.out.println(ch);
        System.out.println("end");


    }
}


abstract class Ex{
    public int color;

}