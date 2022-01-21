package main.java.interfaces;

public class DefaultInvolation /*implements Default*/{
    public static void main(String[] args) {
        Default.printer();
    }

}


interface Default{
    static void printer(){
        System.out.println("from default method");
    }
}