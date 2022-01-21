package main.java;


/*
* аргумент передается по ЗНАЧЕНИЮ
* */
public class ByValueOrByReference {

    public static void main(String[] args) {

        PassedByValue passedByValue = new PassedByValue();

        referenceChanger(passedByValue);
        // после обнуления в методе - ссылка осталась рабочей - то есть в метод передали КОПИЮ

        System.out.println("A : " + passedByValue);
        passedByValue.printer();

    }

    static void referenceChanger(PassedByValue passedByValue){
        passedByValue = null;
//        assert a != null;
        // всегда будет исключение :)
        try {
            passedByValue.printer();
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("Exception");
        }

    }
}

class PassedByValue {
    void printer(){
        System.out.println("isWorking");
    }
}