package tec.juc;

import java.util.concurrent.Callable;

class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}
public class CallableDemo {
    public static void main(String[] args) {

    }
}
