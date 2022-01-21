package main.java.IOutil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class ReaderWriter {

    public static void writeRandomIntegers(BufferedWriter writer) throws IOException {
        Random random = new Random();
        writer.write(String.valueOf(10));
        writer.write('\n');

        for (int i = 0; i < 10; i++) {
            writer.write(String.valueOf(random.nextInt(2_000_000)));
            writer.write(" ");
            writer.write(String.valueOf(random.nextInt(2_000_000)));
            writer.write('\n');
        }
        writer.flush();
        writer.close();
    }

    public static String[] readKnownCountOfStrings(BufferedReader reader) throws IOException {
        int stringCount = Integer.parseInt(reader.readLine());

        String[] strings = new String[stringCount];

//        Stream<String> stream = Arrays.stream(strings);

        for (int i = 0; i < stringCount; i++) {
            strings[i] = reader.readLine();
        }

        return strings;
    }
}
