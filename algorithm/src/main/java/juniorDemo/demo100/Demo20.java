package juniorDemo.demo100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//有效的括号
public class Demo20 {

    public static Map<Character, Character> map = new HashMap<Character, Character>();

    public static void main(String[] args) {
            map.put(')', '(');
            map.put('}', '{');
            map.put(']', '[');
    }

    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return true;
    }


}
