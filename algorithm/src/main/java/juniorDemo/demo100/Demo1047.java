package juniorDemo.demo100;

/**
 * 删除字符串中的所有相邻重复项
 */
public class Demo1047 {
    
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (char ch : S.toCharArray()) {
            if (left != 0 && ch == sb.charAt(left - 1)) {
                sb.deleteCharAt(left-- - 1);
            } else {
                sb.append(ch);
                left++;
            }
        }
        return sb.toString();
    }
}
