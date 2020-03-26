package juniorDemo.demo100;

import org.junit.Test;

//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
// 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//如果不存在最后一个单词，请返回 0 
public class Demo58 {
    @Test
    public void test01(){
        lengthOfLastWord(" ");
    }
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        String[] split = s.split(" ");
        if (split.length == 0) return 0;
        String s1 = split[split.length - 1];

        return s1.length();
    }
}
