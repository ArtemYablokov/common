package main.java.alishev.multithreading.blockWholeObject;


/*
* Каждый метод синхронизован на РАЗНЫХ полях класса - но блокируются ВСЕ поля = ВЕСЬ КЛАСС для каждого из них.
* В данном примере БЛОК так и не снимется
*
* Поэтому методы выполняются последовательно (до второго дело не дойдет)
* */

public class LockWholeObject {

    static int counter1;
    static int counter2;

    static synchronized void increment1(){
        System.out.println(Thread.currentThread().getState());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter1++;
        System.out.println(Thread.currentThread().getName() + counter1);
    }
    static synchronized void increment2(){
        System.out.println(Thread.currentThread().getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter2++;
        System.out.println(Thread.currentThread().getName() + counter2);
    }

    public static void  runThread1() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true){
                            increment1();
                        }
                    }
                }, "First Thread ").start();
    }
    public static void  runThread2() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("vfdvsdvds");
                       while (true){
                           increment2();
                       }
                    }
                }, "Second Thread ").start();
    }

    public static void main(String[] args) {
        runThread1();
        runThread2();
    }
}

//
