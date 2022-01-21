package com.yabloko.polymorph;

public class Test {
    public static void main(String[] args) {
        B b = new B();
        A a = b;
        System.out.println(a instanceof A);
        System.out.println(a instanceof B);
        a = new A();
        System.out.println(a instanceof B);

    }
}

class A{
    void a(){}
}
class B extends A {
    void b(){};
}
