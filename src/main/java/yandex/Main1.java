package main.java.yandex;

import java.io.*;

public class Main1 {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line = bufferedReader.readLine();
        bufferedReader.close();
        String[] s = line.split(" ");
        long summ = 0;
        for (int i = 0; i < s.length; i++) {
            summ += Integer.parseInt(s[i]);
        }
        BufferedWriter stream = new BufferedWriter(new FileWriter(fileName));
        stream.write(String.valueOf(summ));
        stream.write(" ");
        stream.write(String.valueOf(summ));
        stream.flush();
        stream.close();
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println();

    }
}
