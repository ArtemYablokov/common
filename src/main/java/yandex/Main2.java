package main.java.yandex;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        String fileName = "input.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = bufferedReader.readLine();
        bufferedReader.close();
        String[] s = line.split(" ");
        long summ = 0;
        for (int i = 0; i < s.length; i++) {
            summ += Integer.parseInt(s[i]);
        }
        fileName = "output.txt";
        BufferedWriter stream = new BufferedWriter(new FileWriter(fileName));
        stream.write(String.valueOf(summ));
        stream.flush();
        stream.close();

    }
}