package main.java.yandex;

import java.io.*;

/*СТАНДАРТНЫЙ ВЫВОД */
public class Main3 {
    public static void main(String[] args) throws IOException {

//        int read = System.in.read();
//        StringBuilder stringBuilder = new StringBuilder();
//
//        while (read > 0){
//
//        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        bufferedReader.close();
        String[] s = line.split(" ");
        long summ = 0;
        for (int i = 0; i < s.length; i++) {
            summ += Integer.parseInt(s[i]);
        }

        String s1 = new String(new char[]{'d', 'a'});
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write(String.valueOf(summ));

        bufferedWriter.write(s1);
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}