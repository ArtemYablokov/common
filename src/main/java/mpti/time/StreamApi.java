package main.java.mpti.time;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {


        List<Integer> integers = Arrays.asList(9, 1, 3, 5, 5, 3); //без параметризации - анчекд колл ту а роу тайп
//        Stream.of(1, 3, 5, 5, 3)
        integers.stream().distinct().forEach(System.out::println);

        Stream<Integer> stream = integers.stream();
        stream.sorted().forEach(System.out::println);

        stream.sorted((num1, num2) -> {
            if (num1.equals(num2))
                return 0;
            else
                return num1 - num2 > 0 ? 1 : -1;
        });

    }
}