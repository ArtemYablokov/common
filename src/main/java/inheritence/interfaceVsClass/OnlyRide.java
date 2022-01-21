package main.java.inheritence.interfaceVsClass;

public class OnlyRide extends SimpleVehicle {

    @Override
    void doYorJob() {
        System.out.println("can RIDE");
    }

    void rideOwnFeature(){
        System.out.println("only RIDE feature");
    }
}
