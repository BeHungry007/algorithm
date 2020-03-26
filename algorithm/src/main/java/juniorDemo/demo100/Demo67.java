package juniorDemo.demo100;


import org.junit.Test;

//二进制求和
public class Demo67 {
    @Test
    public void test01(){
        addBinary("1010", "1011");
    }
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int count = 0;
        StringBuffer sb = new StringBuffer();
        if (m < n)
            return addBinary(b, a);
        int j = n - 1;
        for (int i = m - 1; i >= 0 ; i--) {
            if (a.charAt(i) == '1') {
                count++;
            }
            if (j > -1 && b.charAt(j--) == '1') {
                count++;
            }
            sb.append(count % 2);
            count = count / 2;
        }
        if (count == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
