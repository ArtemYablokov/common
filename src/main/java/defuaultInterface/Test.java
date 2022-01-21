package main.java.defuaultInterface;

public class Test implements A /*, B*/{
    public static void main(String[] args) {
        new Test().test();
    }
}

interface A{
    default void test(){
        System.out.println("A");
    }
}

//interface B{
//    default void test(){
//        System.out.println("B");
//    }
//}