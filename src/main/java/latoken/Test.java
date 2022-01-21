package main.java.latoken;

import java.io.IOException;

/**
* Тест на синтаксис JAVA в LATOKEN
* */

public /*final*/ class  Test {
    int num;
    String string;
    String description = "Test";


    Test method(){
        return new Test("");
    }

    public Test(){}

    public Test(int num){
        this.num = num;
    }

    public Test(String string){
        this(9);
        this.string = string;
        System.out.println(this.getClass());
    }

    @Override
    public String toString() {
        return "Test{" +
                "num=" + num +
                ", string='" + string + '\'' +
                '}';
    }

    public static void main(String[] args) {
        int i = 2;
        i = ++i + i + ++i;
        System.out.println(i);

        int[] array = {2};
        System.out.println(array.getClass());

        System.out.println(new TestExtender().method().description);

        new Object().toString();


    }
}


class TestExtender extends Test {
    String description = this.toString();

    public TestExtender(){
        super("empty");
    }

    TestExtender(String string){
        super(string);
        System.out.println(this.getClass());
    }
    @Override
    TestExtender method(){
        return this;
    }
}