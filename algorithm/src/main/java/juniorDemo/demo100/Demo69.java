package juniorDemo.demo100;

//求x的平方根
public class Demo69 {
    public int mySqrt(int x) {
        if(x < 2) {
            return x;
        }
        int left = mySqrt(x >> 2) << 1;
        int right = left + 1;
        return right * right > x ? left : right;
    }
}
