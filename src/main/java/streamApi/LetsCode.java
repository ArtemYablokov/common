package main.java.streamApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.*;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;

public class LetsCode {

    public static void main(String[] args) throws IOException {


        // EPAM
        String chars = "aaabbbbccddd";
        char[] chars1 = chars.toCharArray();
        Stream<char[]> chars11 = Stream.of(chars1);
        chars11.distinct().forEach(System.out::println);


        List<String> list = List.of("abc", "def");
        List<String> strings = asList("abc", "def");

        list.forEach((string) -> System.out.println(string.length())); // без указания string не может вывести тип


        boolean digit = isDigit(' '); //

        int count = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);
        int count2 = Stream.of(1, 2, 3)
                .reduce(0, Integer::sum);

        System.out.println(count2);

        Stream<String> lines = Files.lines(Paths.get(""));
        long count1 = lines.count();

        Stream<String> stringStream = lines.flatMap(s -> List.of("", s).stream());
        stringStream.forEach(s -> System.out.println(s));
        stringStream.forEach(System.out::println);


//        int i = 0;
//
//        var variable = 'n';
//        i = variable;
//        System.out.println(i);
//
//        list.forEach(var -> System.out.println(var));


    }
}