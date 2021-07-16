package sort.arrayTest.middle;

/**
 * 给定一个非负整数数组和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 *
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 */
public class SplitArray410 {

    /**
     * 1. 首先获取到这个数组中全部数据相加的总和sum，以及数组里面的最大值l；
     * 2. 取sum和l的平均数mid，然后遍历整个数组求和。一旦求和mid大于mid，此时将分组数count加1，mid == nums[i];
     * 3. 遍历完成之后，如果count > m，l = mid + 1; 如果 count <= m, sum = mid;
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        long l = nums[0],sum = 0;
        for(int i : nums){
            sum += i;
            l = l > i ? l : i;
        }
        while(l < sum){
            long mid = l + (sum-l)/2;
            int cnt = 1;
            long tmp = 0;
            for(int i : nums){
                tmp += i;
                if(tmp > mid){
                    tmp = i;
                    cnt++;
                }
            }
            if(cnt>m){
                l = mid+1;
            }else{
                sum = mid;
            }
        }
        return (int)sum;
    }
}
