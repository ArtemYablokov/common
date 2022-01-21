package main.java.alishev.multithreading.variableVisiable;

//import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.Callable;

public class Vision {
    public static int var = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                var++;

            }
        });
    }
}

class Call implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}

class Outer{
    void runThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Vision.var++;
            }
        });
    }
}
