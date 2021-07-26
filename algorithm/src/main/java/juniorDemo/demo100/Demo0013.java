package juniorDemo.demo100;

/*罗马数字转整数*/


import org.junit.Test;

public class Demo0013 {
    @Test
    public void test01(){
        String s = "VX";
        RomanToInt(s);
    }

    public int RomanToInt(String s) {
        Integer sum = 0;
        char c = s.charAt(0);
        int preNum = getInteger(c);
        for (int i = 1; i < s.length(); i++) {
            int nowNum = getInteger(s.charAt(i));
            if (preNum < nowNum) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = nowNum;
        }
        sum += preNum;
        return sum;
    }

    public int getInteger(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

