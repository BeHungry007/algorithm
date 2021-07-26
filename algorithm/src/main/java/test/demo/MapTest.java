package test.demo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.elasticsearch.common.collect.CopyOnWriteHashMap;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.*;

public class MapTest {

    public Gson gson = new Gson();
    @Test
    public void testhashMap(){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("aa", "sdf");
        map.put("bb", "sdf");
        map.get("aa");
        String s = map.get(1);
        System.out.println(s);
        System.out.println(map.get("cc"));
        String s1 = map.toString();
        int i = 1 << 30;
        System.out.println(i);
        HashMap<String, Object> m = new HashMap<>();
        m.put("a",map);
        m.put("bb", "cc");
        HashMap<String, String> map1 = (HashMap<String, String>)m.get("a");
        System.out.println(map1.get("aa"));
        String bb = (String)m.get("bb");
        System.out.println(bb);

    }

    @Test
    public void testLinkedHashMap(){
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("aa","sdf");
        map.put("bb","bb");
        map.get("aa");
        String s = map.get(1);
        System.out.println(s);
    }

    @Test
    public void test01(){
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        System.out.println(set.toString());
        HashSet<String> set1 = new HashSet<>();
        set1.add("b");
        set1.add("a");
        System.out.println(set1.toString());

//        map.put("0",set);
//
//        String s = gson.toJson(map);
//        JsonObject jsonObject = jsonParser.parse(s).getAsJsonObject();
//        HashMap<String, String> hashMap = gson.fromJson(jsonObject, HashMap.class);
//        String a = hashMap.get("0");
//        System.out.println(a);

    }

    @Test
    public void test02(){

        String s = "2020-09-28_1_2020-09-28_b";
        String[] split = s.split("_");
        System.out.println(split.toString());
        System.out.println(split[0] == split[2]);// false
        String s1 = "aa";
        String s2 = "aa";
        System.out.println(s1 == s2);            // true

    }

    @Test
    public void test03(){
        String s = "{\"name\":\"aa\"}";
        JsonParser jp = new JsonParser();
        JsonObject obj = jp.parse(s).getAsJsonObject();
        System.out.println(obj.get("age"));
        if (obj.get("age").getAsString() != null) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }
    }

    @Test
    public void test04(){
        String s = "sdf";
        String[] split = s.split("_");
        System.out.println(split.length);
    }

    @Test
    public void test05(){
        String s = "asfsd\\sdf\\\\ksdf";
        String[] split = s.split("\\\\");
        System.out.println(split[split.length - 2]);
    }

    @Test
    public void test09() {
        String s = "{\"a\": \"a\", \"b\": \"c\"}";
        JsonParser jp = new JsonParser();
        jp.parse(s).getAsJsonObject();
        Set<Class<?>> clazzs = new HashSet<>();
        clazzs.add(Person.class);
        Set<Person> ss = new HashSet<>();
        clazzs.forEach(clazz -> ss.add((Person) new Gson().fromJson(s, clazz)));
        Iterator<Person> iterator = ss.iterator();
        System.out.println(iterator.next().a);


    }

    @Test
    public void test11(){
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        s1.add("aa");
        System.out.println(s1.containsAll(s2));

    }

    @Test
    public void test13(){
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.compareAndSet(3, 4));
        System.out.println("aa");
        atomicInteger.getAndIncrement();
        Collections.synchronizedList(new ArrayList<>());
        new Vector<String>();
        new CopyOnWriteArrayList<>();
        new HashMap<>();
        new HashSet<>();
        new CopyOnWriteArraySet<>();
        new CopyOnWriteHashMap<>();
        new ConcurrentHashMap<>();
        new ReentrantLock();

    }

    @Test
    public void test013() {



    }
    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.currentThread().getName() + "\t come in");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();

        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.currentThread().getName() + "\t invoked muUnlock");
    }

    public static void main(String[] args) {
        MapTest mapTest = new MapTest();
        new Thread(() -> {
            mapTest.myLock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mapTest.myUnlock();
        }, "AA").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            mapTest.myLock();
            mapTest.myUnlock();
        }, "BB").start();
    }


}
