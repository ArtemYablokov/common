package main.java.alishev.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDown {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
//        executorService.s(Runnable / Callable)

    }
}
