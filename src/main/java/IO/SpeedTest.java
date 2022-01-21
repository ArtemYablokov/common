package main.java.IO;

import main.java.IOutil.ReaderWriter;

import java.io.*;

public class SpeedTest {

    private static String fileName = "/Users/banana/Desktop/file.txt";

    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(
//                new BufferedReader(new InputStreamReader(System.in)).readLine()
//        )));

        long beforeWrite = System.currentTimeMillis();

        ReaderWriter.writeRandomIntegers(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))));

        long afterWrite = System.currentTimeMillis();

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(fileName)));

        FileInputStream fileInputStream = new FileInputStream(fileName);

        int available = fileInputStream.available();
        for (int i = 0; i < available; i++) {
        }

        int read;
        while ((read = fileInputStream.read()) != -1) {

        }

        byte[] bytes = new byte[available];
        fileInputStream.read(bytes);


    }
}
