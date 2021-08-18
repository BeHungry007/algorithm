package utils;

import org.apache.commons.net.time.TimeUDPClient;
import org.jboss.netty.util.internal.ConcurrentHashMap;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * -XX:+UseParallelGC
 * -XX:InitialHeapSize=20971520
 * -XX:MaxHeapSize=20971520
 * -XX:MaxNewSize=10485760
 * -XX:MaxTenuringThreshold=15
 * -XX:NewSize=10485760
 * -XX:+PrintGCDetails
 */
public class Test1 {

    private static Test1 instance = null;

    private Test1 () {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo");
    }

    public static Test1 getInstance() {
//        if(instance == null) {
            synchronized (Test1.class) {
                if (instance == null) {
                    instance = new Test1();
                }
            }
//        }
        return instance;
    }

    public static void main(String[] args) {
        new ReentrantLock().lock();
        new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Test1.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
