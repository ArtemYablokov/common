package com.yabloko.recursion;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

public class StringMixer2 {

    static private String entry;
    static private String[] result;
    static private char[] container; // здесь накапливается строка до момента записи в результат

    static private int counter = 0;
//    static private int key = 0; // проходит по индексам контейнера

    public StringMixer2(String entry) {
        this.entry = entry;
    }


    public static void function(char[] entry/*, int key*/) {
//        int innerKey = key;  // нужна внутренняя переменная снаружи каждого цикла
        for (int i = 0; i < entry.length; i++) {
            int containerIndex = container.length - entry.length;
            container[containerIndex] = entry[i];
//            innerKey++;

            if (containerIndex == container.length-1) // если находимся на последнем индексе контейнера
            {
//                key = 0; // здесь неправильно скидывать K
                result[counter++] = new String(container).intern(); // здесь  надо new String()
//                return;
                continue;
            }

            // создаем массив без вставленного символа
            char[] entryWithoutChar = new char[entry.length - 1];
            int tempIndex = 0;
            for (int j = 0; j < entry.length; j++) {
                if ( j == i )
                    continue;
                entryWithoutChar[tempIndex] = entry[j];
                tempIndex++;
            }
            function(entryWithoutChar/*, innerKey*/);
        }
    }

    static public /*String[]*/ void getAllMixes(){
        result = new String[factorial(entry.length())];
        container = new char[entry.length()];
        function(entry.toCharArray()/*, 0*/);
//        return result;
        ;
    }

    public void getAllStrings(){
        getAllMixes();
        int onOneString = entry.length() - 1 ;
        for (int i = 0; i < result.length; i++) {
            System.out.printf(result[i] + " ");
            if ((i+1)%onOneString == 0)
                System.out.println();
        }
        System.out.println("факториал = " + result.length);
    }

    static private int factorial(int numb){
        int result = 1;
        while (numb > 0){
            result = result * numb;
            numb--;
        }
        return result;
    }

    public static void main(String[] args) {
            Scanner scanner = new Scanner(new StringReader("abcdef"));
        String entry = scanner.nextLine();
        scanner.close();
        System.out.printf("Вводим строку : %s", entry);

        StringMixer2 stringMixer2 = new StringMixer2(entry);
        System.out.println("\nполучаем n-факториал перестановок : ");

        stringMixer2.getAllStrings();

//        System.out.println(factorial("ЭНЕРГОЭФФЕКТИВНОСТЬ".length()));
    }
}
