package sort.arrayTest.middle;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    List<String> ans = new ArrayList<>();

    static final int COUNT = 4;

    int[] seg = new int[COUNT];

    public List<String> restoreIpAddresses(String s) {

        if (s.length() < 4) {
            return ans;
        }
        dfs(s, 0, 0);

        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == COUNT) {
            if (s.length() == segStart) {
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < seg.length; i++) {
                    sb.append(seg[i]);
                    if (i != COUNT) {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            return;
        }
        if (segId == s.length()) {
            return;
        }
        if (s.charAt(segStart) == '0') {
            dfs(s, segId + 1, segStart + 1);
        }

        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr >= 0 && addr <= 255) {
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }

    }
}
