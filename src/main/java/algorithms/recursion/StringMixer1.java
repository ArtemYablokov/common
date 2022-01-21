package com.yabloko.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class StringMixer1 {

    static private String entry;
    static private String[] result;
    static private char[] container; // здесь накапливается строка до момента записи в результат

    static private int counter = 0;
    static private int key = 0; // проходит по индексам контейнера

    public StringMixer1(String entry) {
        this.entry = entry;
    }


    private static void function(char[] entry) {
        for (int i = 0; i < entry.length; i++) {
            container[key++] = entry[i];

            if (key == container.length) // если находимся на последнем индексе контейнера
            {
                key = 0; // здесь неправильно скидывать K
                result[counter++] = Arrays.toString(container);
                return;
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
            function(entryWithoutChar);
        }
    }

    static public String[] getAllMixes(){
        result = new String[factorial(entry.length())];
        container = new char[entry.length()];
        function(entry.toCharArray());
        return result;
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
        Scanner scanner = new Scanner(System.in);
        String entry = scanner.nextLine();
        scanner.close();
        System.out.printf("Enered : %s", entry);

        StringMixer1 stringMixer1 = new StringMixer1(entry);
        String[] allMixes = stringMixer1.getAllMixes();

        System.out.println(Arrays.toString(allMixes));

//        System.out.println(factorial(3));


    }
}
