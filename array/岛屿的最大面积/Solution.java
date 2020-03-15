/**
给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

*/
class Solution {
    int rowMax;
    int colMax;
    public int maxAreaOfIsland(int[][] grid) {
        rowMax=grid.length;
        colMax=grid[0].length;
        int max=0;
        for(int i=0;i<rowMax;i++){
            for(int j=0;j<colMax;j++){
                if(grid[i][j]==1)
                max=Math.max(max,land(grid,i,j));
            }
        }
        return max;
    }
    public int land(int[][] grid,int row, int col){
        if(row>=0&&row<rowMax&&col>=0&&col<colMax&&grid[row][col]==1){
            grid[row][col]=0;
            return 1+land(grid,row+1,col)+land(grid,row-1,col)+land(grid,row,col+1)+land(grid,row,col-1);
        }
            return 0;
        
        
    }
}
