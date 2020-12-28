package face;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockTest {

    public static void main(String[] args) {
        SpinLockTest spinLockTest = new SpinLockTest();
        new Thread(() -> {
            spinLockTest.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            spinLockTest.unMyLock();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockTest.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
            spinLockTest.unMyLock();
        },"B").start();
    }


    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    Integer i = 0;

    public void myLock() {
        Thread t = Thread.currentThread();
        System.out.println(t.currentThread().getName() + " come in");
        //while (!atomicReference.compareAndSet(null, t)) {}
        while (i == 0) {
            i = 1;
        }
    }

    public void unMyLock() {
        Thread t = Thread.currentThread();
        //atomicReference.compareAndSet(t, null);
        i = 0;
        System.out.println(t.currentThread().getName() + " invoked unMyLock()");
    }
}
