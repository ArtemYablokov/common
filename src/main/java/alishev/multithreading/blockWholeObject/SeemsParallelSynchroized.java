package main.java.alishev.multithreading.blockWholeObject;
/*
* в этом примере БЛОКИРОВКА тодлько на методе ИНКРЕМЕНТА следовательно
* все остальное время ЗАДАЧА уступит блокировку сопернику
*
* кажется что методы параллельно обращаются к полю - но нет, строго последовательно
* */


public class SeemsParallelSynchroized {

    static int counter1;
    static int counter2;

    static synchronized void increment1() {
        counter1++;
        System.out.println(Thread.currentThread().getName() + counter1);
    }

    static synchronized void increment2() {
        counter2++;
        System.out.println(Thread.currentThread().getName() + counter1);
    }

    public static void runThread1() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            System.out.println(Thread.currentThread().getState());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            increment1();
//                            System.out.println(Thread.currentThread().getName() + counter1);
                        }
                    }
                }, "First Thread ").start();
    }

    public static void runThread2() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true) {

                            System.out.println(Thread.currentThread().getState());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            increment1();
//                            System.out.println(Thread.currentThread().getName() + counter1);
                        }
                    }
                }, "Second Thread ").start();
    }

    public static void main(String[] args) {
        runThread2();
        runThread1();
    }
}

//
