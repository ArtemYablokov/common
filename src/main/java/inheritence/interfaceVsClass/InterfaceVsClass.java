package main.java.inheritence.interfaceVsClass;

/*
* 1 ИНТЕРФЕЙС = ОКНО
* 2 ПОЛИМОРФНОСТЬ = какая из реализаций метода вызовется - зависит от ОБЪЕКТА по ссылке а не ТИПА ссылки
* 3 КЛАСС (ссылка) = такое же окно как и интерфейс
* 4 при извлечении из типизированной коллекции - даже сохранится класс !!!
* точнее - метод  getClass() вызывается у наследника - ТК полиморфизм :)
* ссылка то остается РОДЕТЕЛЕМ
*
* PS статические методы НЕ БИНДЯТСЯ
* */

import java.util.ArrayList;
import java.util.Collections;

public class InterfaceVsClass {
    public static void main(String[] args) {

        // 1 класс реализует оба интерфейса. но ссылка ТИПА ИНТЕРФЕЙСА обрезает не свои методы
        Flyable flyable = new FlyRIdeImpl();
        Ridable ridable = new FlyRIdeImpl();
        // ТОЛЬКО ОДИН МЕТОД ДОСТУПЕН - ИНТЕРФЕЙС ОБРЕЗАЕТ ФУНКЦИОНАЛЬНОСТЬ
        flyable.fly();
        ridable.ride();

        // 2 ПОЛИМОРФНОСТЬ
        // объект можно присвоить ссылке типа РОДИТЕЛЯ. но при этом будет вызвана реализация метода НАСЛЕДНИКА !!!
        ArrayList<OnlyRide> simpleVehicles = new ArrayList<>();
        Collections.addAll(simpleVehicles, /*new SimpleVehicle(),*/ new OnlyFly(), new OnlyRide());
        for (OnlyRide simpleVehicle : simpleVehicles){
            System.out.println(simpleVehicle.getClass()); // даже сохраняется класс наследника
            simpleVehicle.doYorJob();
            simpleVehicle.rideOwnFeature();
        }
        // 3 ВЫШЕ так же и ССЫЛКА класса обрезает функциональность как и интерфейс

        SimpleVehicle simpleVehicle = new OnlyRide();
        System.out.println(simpleVehicle.getClass());


    }
}



