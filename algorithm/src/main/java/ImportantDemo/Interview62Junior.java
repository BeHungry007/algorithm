package ImportantDemo;

import org.junit.Test;

import java.util.ArrayList;

public class Interview62Junior {
    @Test
    public void test01(){

    }

    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        if (n == 1) {
            return 0;
        }
        int index = 0;
        while (n > 1) {
            index = (index + m -1) % n;
            list.remove(index);
        }
        return list.get(0);
    }

    public int lastRemaining1(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
