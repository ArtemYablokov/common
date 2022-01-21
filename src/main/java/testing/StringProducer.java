package main.java.testing;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringProducer {
    private String string;

    public StringProducer(String string) {
        this.string = string;
    }

    public String getString(){
        StringBuilder reverse = new StringBuilder(string).reverse();
        return String.valueOf(reverse);
    }

}
