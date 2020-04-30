package middleDemo.Demo100;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Arrays;

/**
 * 最接近的三数之和
 */
public class Demo016 {
    @Test
    public void test01(){

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - ans) > Math.abs(target - sum)){
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
