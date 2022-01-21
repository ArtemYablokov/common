package main.java;

public class ClassCastExceptionTest {
    public static void main(String[] args) {
//        B a = (B) new A();

        PassedByValue aTypeRef = new B();
        B bTypeRef = (B) aTypeRef;
        // все ОК - ссылка хранит НАСЛЕДНИКА ->
        // функционал реализован чтобы присвоить ссылке НАСЛЕДНИКА

        aTypeRef = new PassedByValue();
        bTypeRef = (B) aTypeRef;
        // ClassCastException так как ссылка ссылается на родителя ->
        // он реализует функционал наследника ->
        // соответственно не предоставляет тех методов что наследник ->
        // вызвав один из них по ссылке будет ТРЕШ - поэтому комилятор не пропускает такое

    }
}
//class A implements LinkedList {}
//interface B extends A{}

class A {}

class B extends PassedByValue {}