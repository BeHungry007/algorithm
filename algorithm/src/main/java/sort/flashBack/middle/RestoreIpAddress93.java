package sort.flashBack.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 */
public class RestoreIpAddress93 {

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append(".");
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        if (segStart == s.length()) {
            return;
        }

        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        int addr = 0;
        for(int segEnd = segStart; segEnd < s.length(); segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    public void dfs1(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append(".");
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        if (segStart == s.length()) {
            return;
        }

        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs1(s, segId + 1, segStart + 1);
        }

        int addr = 0;

        for (int segEnd = segStart; segEnd < s.length() ; segEnd++) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 255) {
                dfs1(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }
}
