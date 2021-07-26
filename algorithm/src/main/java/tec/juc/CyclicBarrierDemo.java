package tec.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("完成，结束！！！！");
        });
        for (int i = 0; i < 7; i++) {
            new Thread(() -> {

                System.out.println(Thread.currentThread().getName() + "come in");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }, i + "").start();
        }
    }
}
