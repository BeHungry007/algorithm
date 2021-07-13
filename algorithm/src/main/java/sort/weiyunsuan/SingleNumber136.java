package sort.weiyunsuan;

public class SingleNumber136 {

    public int singleNumber136(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
