package ImportantDemo;

import java.util.HashMap;
import java.util.Map;

//多数元素
public class Demo169Junior {

    public static void main(String[] args) {
        int[] arr = {3,2,3};
        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer , Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > nums.length/2) {
                    return nums[i];
                }
            } else {
                map.put(nums[i] , 1);
            }
        }
        return 0;
    }
}
