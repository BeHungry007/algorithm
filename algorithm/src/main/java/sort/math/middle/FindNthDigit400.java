package sort.math.middle;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第
 * 5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 *
 * 请写一个函数，求任意第n位对应的数字。
 *
 */
public class FindNthDigit400 {
    String s = "0123456789101112131415";

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 2. 此处减1，为防止溢出：当n位于14的4位置时，若不减1则会算成15。
        long num = start + (n - 1) / digit;
        // 3. 此处减1，为减去0所在的位置;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
