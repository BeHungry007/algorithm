package sort.ArrayTest.junior;

import org.junit.Test;

import java.util.Arrays;

/**
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 *
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 *
 */
public class NumPairsDivisibleBy60 {

    @Test
    public void test01(){
        int[] time = {30, 20, 150, 100, 40};
        numPairsDivisibleBy601(time);
    }
    public int numPairsDivisibleBy60(int[] time) {
        Arrays.sort(time);
        int[] counts = new int[time.length];
        int count = 0;
        int left = 0;
        int right = time.length;
        for (left = 0; left < time.length - 1; left++) {
            if(left > 0 && time[left] == time[left - 1]) {
                if (time[left] * 2 % 60 == 0) {
                    counts[left] = counts[left - 1] - 1;
                    continue;
                } else {
                    counts[left] = counts[left - 1];
                    continue;
                }
            }
            for (int j = time.length - 1; j > left ; j--) {
                if ((time[left] + time[j]) % 60 == 0) {
                    counts[left] = counts[left] + 1;
                }
            }
        }
        for (int i = 0; i < time.length; i++) {
            count += counts[i];
        }
        return count;
    }

    public int numPairsDivisibleBy601(int[] time) {
        int count = 0;
        int[] seconds = new int[60];
        for (int i : time) {
            seconds[i % 60] += 1;
        }
        count += com(seconds[30], 2);
        count += com(seconds[0], 2);
        int i = 1;
        int j = 59;
        while (i < j) {
            count += (seconds[i++] * seconds[j--]);
        }
        return count;
    }
    public int com(int m, int n) {
        int sum = 0;
        for (int i = 1; i < m; i++) {
            sum += (m - i);
        }
        return sum;
    }
}
