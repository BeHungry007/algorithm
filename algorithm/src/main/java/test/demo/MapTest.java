package test.demo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.util.*;

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
    public void test12(){
        int i = 1;
        int j = ++i;
        int k = i++;
        System.out.println(j);
        System.out.println(k);
    }

    @Test
    public void test13(){
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(nums[0][2]);

    }

    @Test
    public void test022(){

    }




}
