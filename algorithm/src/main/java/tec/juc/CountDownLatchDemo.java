package tec.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 7; i++) {
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + "leave");
                countDownLatch.countDown();

            }, i + "").start();
        }
        System.out.println(Thread.currentThread().getName() + "finish");
    }
}
