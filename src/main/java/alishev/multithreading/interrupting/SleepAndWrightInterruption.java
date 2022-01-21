package main.java.alishev.multithreading.interrupting;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SleepAndWrightInterruption {
    public static void main(String[] args) throws InterruptedException {


        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Math.sin(new Double("8"));
                    // ПРАВИЛЬНАЯ ОБРАБОТКА ПРЕРЫВАНИЯ - МОЖНО ВЫПОЛНИТЬ ЗАВЕРШАЮЩИЕ ДЕЙСТВИЯ
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("use isInterrupted");
                        break;
                    }
                }
            }
        };
//        Thread thread = new Thread(r);
//        thread.start();
//        thread.interrupt();

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("sleep interrupted");
                        break; // БЕЗ этого поток продолжит выполнение тк interrupt не завершает поток !
                    }
                }
            }
        };

//        Thread thread2 = new Thread(r2);
//        thread2.start();
//        thread2.interrupt();

        Runnable r3 = new Runnable() {
            @Override
            public void run() {
                while (true) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println("throwing RuntimeException");
                    throw new RuntimeException();
                }
            }
        };



//        Thread thread3 = new Thread(r3);
//        thread3.start();


        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(r3);

//        Future<?> f = executorService.submit(r);
//        f.cancel(true); // вызывает метод interrupt()
//        Future<?> f2 = executorService.submit(r2);
//        f2.cancel(true);
        Future<?> f3 = executorService.submit(r3);

        Thread.sleep(1100);
        f3.cancel(true);

        executorService.shutdown();

    }
}
