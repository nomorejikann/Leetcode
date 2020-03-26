/**
在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。

车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。

返回车能够在一次移动中捕获到的卒的数量。

*/
class Solution {

    private int getNumRook(int x, int y, char[][] board) {
        int count = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            for (int tx = x, ty = y; tx < board.length && tx >= 0
                    && ty < board.length && ty >= 0; tx += dx[i], ty += dy[i]) {
                if (board[tx][ty] == 'p') {
                    count++;
                    break;
                }
                if (board[tx][ty] == 'B')
                    break;
            }
        }

        return count;
    }
    
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j  = 0; j < board.length; j++) {
                if (board[i][j] == 'R') 
                    return getNumRook(i, j, board);
            }
        }

        return -1;
    }
}
