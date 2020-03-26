package ImportantDemo;

//在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
// 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
//
//车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，
// 直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
// 另外，车不能与其他友方（白色）象进入同一个方格。
//
//返回车能够在一次移动中捕获到的卒的数量。


import org.junit.Test;

public class Demo999Junior {
    @Test
    public void test01(){

    }
    public int numRookCaptures(char[][] board) {
        char ch;
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ch = board[i][j];
                if ('R' == ch) {
                    int res = 0;
                    for (int[] direction : directions) {
                        boolean bornout = bornout(board, i, j, direction);
                        if(bornout) res++;
                    }
                    return res;
                }
            }
        }
        return 0;
    }

    public boolean bornout(char[][] board, int x, int y, int[] direction) {
        while (judge(x, y)) {
            if (board[x][y] == 'B') {
                break;
            }
            if (board[x][y] == 'p') {
                return true;
            }
            x += direction[0];
            y += direction[1];
        }
        return false;
    }

    public boolean judge(int x, int y) {
        return x>=0 && x< 8 && y >= 0 && y < 8;
    }
}
