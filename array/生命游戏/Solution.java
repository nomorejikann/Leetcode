/**
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
*/
class Solution {
    public void gameOfLife(int[][] board) {
        int cm=board.length;
        int rm=board[0].length;
        int[][] ans=new int[cm][rm];
        for(int i=0;i<cm;i++){
            
            for(int j=0;j<rm;j++){
                int l=0;
                if(i-1>=0){
                    l+=board[i-1][j];
                    if(j-1>=0)
                        l+=board[i-1][j-1];
                    if(j+1<rm)
                        l+=board[i-1][j+1];
                }
                if(j-1>=0)
                    l+=board[i][j-1];
                if(j+1<rm)
                    l+=board[i][j+1];
                if(i+1<cm){
                    l+=board[i+1][j];
                    if(j-1>=0)
                        l+=board[i+1][j-1];
                    if(j+1<rm)
                        l+=board[i+1][j+1];
                }
                if(l<2||l>3)
                    ans[i][j]=0;
                if(l==3)
                    ans[i][j]=1;
                if(l==2)
                    ans[i][j]=board[i][j];
                
            }
        }
        for(int i=0;i<cm;i++){
            for(int j=0;j<rm;j++){
                board[i][j]=ans[i][j];
            }
        }
    }
}
