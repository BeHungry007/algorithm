package sort.math.junior;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 */
public class TitleToNumber171 {

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) {
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < columnTitle.length(); i++) {
            ans = ans * 26 + (columnTitle.charAt(i) - 'A') + 1;
        }
        return ans;
    }
}
