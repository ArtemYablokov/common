package main.java.ibs;

public class StaticTEst {
    static {
        int i = 5;
    }
    public static int i = 6;

    public static void main(String[] args) {
        System.out.println(i);
    }
}
