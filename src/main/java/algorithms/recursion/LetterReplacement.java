package main.java.algorithms.recursion;

import java.util.ArrayList;

public class LetterReplacement {
    public static void main(String[] args) {
        char[] chars = "word".toCharArray();
        String str = new String(chars);
        System.out.println(str.charAt(3));
    }

    private static ArrayList<String> results;

    public static void prepare(String word){
        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();


    }
    public static void function(String word, StringBuffer sb){
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sb.append( chars[i] );


            if ( chars.equals("") )
                results.add(sb.toString());
        }
    }

}
