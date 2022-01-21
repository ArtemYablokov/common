package main.java.patterns;

public class SingletoneAnalog {

    private int data;

    private static final SingletoneAnalog singletoneAnalog = new SingletoneAnalog(9);

    private SingletoneAnalog(int data) {
        this.data = data;
    }

    static SingletoneAnalog getSingletoneAnalog(){
        return singletoneAnalog;
    }
}
