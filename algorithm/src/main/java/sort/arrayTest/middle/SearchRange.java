package sort.arrayTest.middle;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class SearchRange {


    @Test
    public void test03(){
        int[] nums = {1,2,5,6};
        int i = extremeInsertionIndex(nums, 3, true);
        System.out.println(i);
    }
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }

    @Test
    public void test01(){
        int a = 4;
        int b = a >> 1;

        System.out.println(b);
    }

    @Test
    public void test02() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date parse = sdf.parse("202102");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(parse);
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    }

    public int left(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int tmp = (left + right) / 2;

        }
        return 1;
    }




}
