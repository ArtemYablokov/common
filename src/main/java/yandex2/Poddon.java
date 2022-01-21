package main.java.yandex2;

import main.java.IOutil.ReaderWriter;

import java.io.*;

public class Poddon {

    public static void main(String[] args) throws IOException {

        String fileName = "/Users/banana/Desktop/file1.txt";

        BufferedWriter stream = new BufferedWriter(new FileWriter(fileName));
        ReaderWriter.writeRandomIntegers(stream);


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = bufferedReader.readLine();
        int total = Integer.parseInt(line);

        int length = 0;
        int width = 0;

        int arrLength = 0;
        // массив
        int [][] array = new int [total][2];

        // запись первого значения
        line = bufferedReader.readLine();
        String[] s = line.split(" ");

        length = Integer.parseInt(s[0]);
        width = Integer.parseInt(s[1]);

        // ставим на первое место бОльшее значение
        if (width > length){
            int temp = length;
            length = width;
            width = temp;
        }

        array[0][0] = length;
        array[0][1] = width;

        arrLength++;

        // считываем значения
        for (int i = 1; i < total; i++) {

            line = bufferedReader.readLine();
            s = line.split(" ");

            length = Integer.parseInt(s[0]);
            width = Integer.parseInt(s[1]);

            // ставим на первое место бОльшее значение
            if (width > length){
                int temp = length;
                length = width;
                width = temp;
            }

            // сравнение с уже имеющимися подносами

            for (int j = 0; j < arrLength; j++) {
                int lengthFromArr = array[i][0];
                int widthFromArr = array[i][1];


                // если длина или ширина БОЛШЕ/РАВНА чем из массива
                if (length >= lengthFromArr || width >= widthFromArr) {

                    // ставим в конец
                    array[arrLength][0] = length;
                    array[arrLength][1] = width;
                    arrLength++;

                    for (int l = 0; l < arrLength; l++) {

                        lengthFromArr = array[l][0];
                        widthFromArr = array[l][1];

                        if (length > lengthFromArr && width > widthFromArr) {
                            array[l][0] = 0;
                        }
                    }

                    // заканчиваем
                    break;
                }

            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i][0]);
//            System.out.print(" ");
//            System.out.println(array[i][1]);
            if (array[i][0] != 0)
                count++;
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(count));
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}