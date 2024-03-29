package tec.suo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionAwaitSignalDemo {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{

            try {
                System.out.println(Thread.currentThread().getName()+" come in.");
                lock.lock();
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

            System.out.println(Thread.currentThread().getName()+" 换醒.");
        },"Thread A").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                lock.lock();
                condition.signal();
                System.out.println(Thread.currentThread().getName()+" 通知.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"Thread B").start();
    }
}
