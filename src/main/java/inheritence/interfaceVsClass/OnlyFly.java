package main.java.inheritence.interfaceVsClass;

public class OnlyFly extends OnlyRide{
    @Override
    void doYorJob() {
        System.out.println("can FLY");
    }

    void flyOwnFeature(){
        System.out.println("only FLY feature");
    }
}
