package juniorDemo.demo100;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//求x的平方根
public class Demo69 {
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        int left = mySqrt(x >> 2) << 1;
        int right = left + 1;
        return right * right > x ? left : right;
    }
    
    @Test
    public void test02(){
        Map<String, String> map = new HashMap<String, String>();
        String aa = map.get("aa");
        System.out.println(aa);
    }
}
