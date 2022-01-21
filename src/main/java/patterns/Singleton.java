package main.java.patterns;

//import main.java.inheritence.Flyable;

public class Singleton  {

    private static int data;

    static Singleton singleton;

    private Singleton(int data) {
        this.data = data;
    }

    static public Singleton getSingletone() {
        if (singleton == null)
            singleton = new Singleton(2);
        return singleton;
    }

    @Override
    public String toString() {
        return super.toString() +
                ": Singleton{} data = " + data;
    }

    public int getData() {
        return data;
    }
}

class Tester {
    public static void main(String[] args) {
        Singleton one = Singleton.getSingletone();
        System.out.println(one);
        System.out.println(Singleton.getSingletone());
        System.out.println(Singleton.getSingletone());
        System.out.println(one.getData());

    }
}