package main.java.inheritence.interfaceVsClass;

public class FlyRIdeImpl implements Flyable, Ridable {
    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName() + "fly()");
    }

    @Override
    public void ride() {
        System.out.println(this.getClass().getSimpleName() + "ride()");
    }
}
