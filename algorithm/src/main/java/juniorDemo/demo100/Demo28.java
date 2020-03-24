package juniorDemo.demo100;

//实现 strStr() 函数。

//给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
// 如果不存在，则返回  -1。

import org.junit.Test;

public class Demo28 {
    @Test
    public void test01(){

    }
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int length1 = haystack.length();
        int length2 = needle.length();
        for (int i = 0; i < length1 - length2; i++) {
            if(needle.equals(haystack.substring(i, i + length2))) {
                return i;
            }
        }
        return -1;
    }
}
