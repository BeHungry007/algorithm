package sort.arrayTest.junior;

import org.junit.Test;

public class FindMaxAverage643 {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        double ans = sum;
        for(int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            ans = Math.max(ans, sum);
        }
        return ans / k;
    }
}
