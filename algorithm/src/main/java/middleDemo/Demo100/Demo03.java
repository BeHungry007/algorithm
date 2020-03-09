//package middleDemo.Demo100;
//
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
///**
// * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
// */
//public class Demo03 {
//
//    /**
//     * 根据map集合put的特点，器返回值为替代的value数值。
//     */
//    @Test
//    public void test03() {
//        String s = "pwwkew";
//        char[] chars = s.toCharArray();
//        int max = 0;
//        for (int i = 0; i < chars.length-max; i++) {
//            Map<String,Integer> map = new HashMap<>();
//            int j = 0;
//            for (int a = i; a < chars.length; a++) {
//                Integer put = map.put(chars[a] + "", j);
//                j++;
//                if (put != null) {
//                    if(put > max){
//                        max = j-1;
//                    }
//                    break;
//                } else {
//                    if(j > max){
//                        max = j;
//                    }
//                }
//            }
//        }
//        System.out.println(max);
//    }
//
//    @Test
//    public void testanswer1() {
//        String s = "pwwkew";
//        int length = s.length();
//        int ans = 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0,j = 0 ; i < length; i++) {
//            if (map.containsKey(s.charAt(i))) {
//                j = Math.max(map.get(s.charAt(i)), j);
//            }
//            ans = Math.max(ans, i - j + 1);
//            map.put(s.charAt(i), i + 1);
//        }
//        System.out.println(ans);
//    }
//
//    @Test
//    public void testanswer2() {
//        String s = "pwwkew";
//        int length = s.length();
//        int ans = 0;
//        int[] index = new int[128];
//        for (int j = 0, i = 0; j <length; j++) {
//            i = Math.max(i, index[s.charAt(j)]);
//            ans = Math.max(ans, j - i + 1);
//            index[s.charAt(j)] = j + 1;
//        }
//        System.out.println(ans);
//    }
//}
