package sort.math.junior;

public class MySqrt69 {

    public int mySqrt(int x) {
        if (x < 4) {
            return x == 0 ? 0 : 1;
        }
        int m = 0;
        int n = x;
        int ans = 0;
        while (m < n) {
            int tmp = (m + n) / 2;
            long count = (long) tmp * tmp;
            if (count > x) {
                n = tmp;
            } else if (count == x) {
                return tmp;
            } else {
                if ((tmp + 1) * (tmp + 1) < x) {
                    return tmp;
                } else {
                    m = tmp;
                }
            }
        }
        return m;
    }
}
