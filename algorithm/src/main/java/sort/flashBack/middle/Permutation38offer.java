package sort.flashBack.middle;

import org.junit.Test;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class Permutation38offer {

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        c = s.toCharArray();
        dfs(0);
        String[] re = res.toArray(new String[res.size()]);
        return res.toArray(new String[res.size()]);
    }

    public void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    @Test
    public void test01(){
        permutation("abcde");
    }

    public String[] permutation1(String s) {

        List<String> res1 = new LinkedList<>();

        if (s == null || s.length() == 0) {
            return null;
        }
        Deque<Character> path = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = "";
        for (int i = 0; i < chars.length; i++) {
            s = s + chars[i];
        }

        int len = s.length();
        boolean[] used = new boolean[chars.length];

        dfs1(res1, s, 0, len, path, used);
        return res1.toArray(new String[res1.size()]);
    }

    public void dfs1(List<String> res1, String s, int current, int len, Deque<Character> path, boolean[] used) {
        if (current == s.length()) {
            String s1 = "";
            for (Character character : path) {
                s1 = s1 + character;
            }
            res1.add(s1);
            return;
        }
        for (int j = 0; j < len; j++) {
            if (used[j] || (j > 0 && s.charAt(j) == s.charAt(j - 1) && !used[j - 1])) {
                continue;
            }
            path.addLast(s.charAt(j));
            used[j] = true;
            dfs1(res1, s, current + 1, len, path, used);
            used[j] = false;
            path.removeLast();
        }
    }
}
