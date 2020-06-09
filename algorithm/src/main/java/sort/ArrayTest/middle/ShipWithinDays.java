package sort.ArrayTest.middle;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
 * 我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (count(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean count(int[] weights, int mid, int D) {
        int we = mid;
        for (int weight : weights) {
            if (weight > mid) return false;
            if (we < weight) {
                we = mid;
                D--;
            }
            we = we - weight;
        }
        return D >= 0;
    }
}
