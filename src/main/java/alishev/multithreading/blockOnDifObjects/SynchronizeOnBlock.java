package main.java.alishev.multithreading.blockOnDifObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
* если доступ к разным данным - можно синхронизировать по разным объектам!
*
* ЦИКЛ нужен один ОБЩИЙ. если его сделать внутри каждой синхронизации - прийдется ждать все 1000 итераций!!!
*
* */


public class SynchronizeOnBlock {
    Random random = new Random();

    final Object lock1 = new Object();
    final Object lock2 = new Object();

    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();


    /*synchronized*/ void addToList1() {
        synchronized (lock1) {
//            for (int i = 0; i < 1000; i++) {
                list1.add(random.nextInt(100));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        }
    }

    /*synchronized*/ void addToList2() {
        synchronized (lock2) {
//            for (int i = 0; i < 1000; i++) {
                list2.add(random.nextInt(100));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        }

    }


    public void work(){
        for (int i = 0; i < 1000; i++) {
            addToList1();
//            Thread.yield();
            addToList2();
        }
    }

    public void test() throws InterruptedException {
        long start = System.currentTimeMillis();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                addToList1();
                work();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                addToList2();
                work();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        long end = System.currentTimeMillis();

        System.out.println(list1.size());
        System.out.println(list2.size());
        System.out.println("took " + (end - start) + " MILISeconds");
    }

    public static void main(String[] args) throws InterruptedException {
        new SynchronizeOnBlock().test();
    }

    private static void testTimeOfAdding() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            list.add(random.nextInt(100));
//            Thread.sleep(1);
        }

        long end = System.currentTimeMillis();

        System.out.println(list.size() + " Integers, took " + (end - start) + " MILISeconds");

        // со сном = 1300 мс
        // без сна 3 мс
        // значит 297 мс требуются на обработку запроса к Thread
    }
}
