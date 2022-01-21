package main.java.algorithms.interview;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SortHashTags {

    public static void main(String[] args) {
        List<String> hashTags = new ArrayList<>();
        hashTags.add("#Java jhkjh #Scala");
        hashTags.add("#Java jhkjh #Scala");
        hashTags.add("lahjfghhfjk #Scala");
        hashTags.add("lahjfghhfjk #Apple");

        sortMostEncounteredHashTags(hashTags);
    }

    private static void sortMostEncounteredHashTags(List<String> text) {
        Map<String, Integer> hashTagsMap = new HashMap<>();
        Pattern pattern = Pattern.compile("#.+?\\b");

        for (String string : text) {
            Matcher matcher = pattern.matcher(string);
            while (matcher.find()) {
                String group = matcher.group();
                Integer integer = hashTagsMap.get(group);
                Integer result = integer == null ? 1 : ++integer;
                hashTagsMap.put(group, result);
            }
        }

        Map<Integer, String> ordered = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : hashTagsMap.entrySet()) {
            ordered.put(entry.getValue(), entry.getKey());
            System.out.println(entry.getKey());
        }

        Set<Map.Entry<Integer, String>> entries = ordered.entrySet();
        List<String> collect = entries.stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        Collections.reverse(collect);

        System.out.println(collect);
    }
}
