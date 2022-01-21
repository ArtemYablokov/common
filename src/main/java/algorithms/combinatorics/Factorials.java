package main.java.algorithms.combinatorics;

import java.math.BigDecimal;
import java.util.Arrays;

public class Factorials {
    public static void main(String[] args) {
//        System.out.println(factorial(1));
//        System.out.println(factorial(2));
//        System.out.println(factorial(3));
//        System.out.println(factorial(5));
//        System.out.println(positions(20, 10));
//        System.out.println(new FactUpgrade().nCount(40, 20));
        new FactUpgrade().factArrayCount( 40, 20);

    }

//    static long factorial(int number){
//        long answer = 1;
//        for (int i = 1; i < number + 1; i++) {
//            answer *= i;
//        }
//        return answer;
//    }
//
//    static long positions(int from, int to){
//        long answer = factorial(from)/(factorial(to) * factorial(from - to));
//        return answer;
//    }
}

class FactUpgrade extends Factorials{

    public BigDecimal nCount(int from, int to){
        int brake = to;
        int down = from - to;
        if ( from - to > to ) {
            brake = from - to;
            down = to;
        }
        BigDecimal n = BigDecimal.valueOf(from);
        for (int i = from - 1; i > brake; i--) {
            n = n.add(BigDecimal.valueOf(i));
        }
        BigDecimal answer = n.divide(BigDecimal.valueOf(fact(down)));
        return answer;
    }

     long fact(int number){
        long answer = 1;
        for (int i = 1; i < number + 1; i++) {
            answer *= i;
        }
        return answer;
    }


    int[] nArray;
    int[] kArray;

    void factArrayCount(int from, int to){
        int brake = to;
        int down = from - to;
        if ( from - to > to ) {
            brake = from - to;
            down = to;
        }
        nArray = new int[from - to];
        kArray = new int[down - 1];

        for (int i = from, j = 0; i > brake ; i--, j++) {
            nArray[j] = i;
        }
        for (int i = down, j = 0; i > 1 ; i--, j++) {
            kArray[j] = i;
        }
        System.out.println(Arrays.toString(nArray));
        System.out.println(Arrays.toString(kArray));

        int num = 1;
        int divisor = 1;

        for (int i = 0; i < nArray.length; i++) {
            num = nArray[i];
            for (int j = 0; j < kArray.length; j++) {
                divisor = kArray[j];
                if (divisor == 1)
                    continue;
                if (num%divisor == 0) {
                    nArray[i] = num / divisor;
                    num = nArray[i];
                    kArray[j] = 1;
                }
            }
//            System.out.println("round " + i);
//            System.out.println(Arrays.toString(n));
//            System.out.println(Arrays.toString(k));
        }
        System.out.println(Arrays.toString(nArray));
        System.out.println(Arrays.toString(kArray));

        long upperNumber = 1;
        int kum = 1;
        for(int n: nArray){
            upperNumber *= n;
            System.out.println("num = " + upperNumber);
        }
        for(int n: kArray){
            kum *= n;
            System.out.println("kum = " + kum);

        }

        System.out.printf("nArray / kArray = %d / %d \n" , upperNumber, kum );
        long result = upperNumber/kum;

        System.out.println(result);
    }
}