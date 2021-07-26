package juniorDemo.demo100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//有效的括号
public class Demo20 {

    @Test
    public void test01(){
        isValid(")(){}(())");
    }



    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
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
