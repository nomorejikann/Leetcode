    /**
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * @param n
     * @return
     */
class Solution {
    public int[][] generateMatrix(int n) {
        int rowMax, colMax, rowMin, colMin, row, col, k;
        rowMax = colMax = n;
        row = col = k = colMin = 0;
        //初始已经加载了第一行
        rowMin = 1;
        int[][] ans = new int[n][n];
        //向右，向下，向左，向上
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        //从1开始
        for(int i = 1; i <= n*n; i++) {
   
        	ans[row][col] = i;
        	//计算下个位置
        	row += dir[k][0];
        	col += dir[k][1];
        	
        	//确认方向和范围
        	switch(k) {
        	  //列最大即向右到底
        	  case 0 : 
        		  if(col >= colMax) {
        		      colMax--;
        		      col = colMax;
        		      //向下
        		      k = 1;
        		      row++;
        	      }
        		  break;
        	  //行最大即向下到底
        	  case 1 :
        		  if(row >= rowMax) {
        			  rowMax--;
        			  row = rowMax;
        			  //向左
        			  k = 2;
        			  col--;
        		  }
        		  break;
        	  //列最小即向左到底
        	  case 2 :
        		  if(col < colMin) {
        			  col = colMin;
        			  colMin++;
        			  //向上
        			  k = 3;
        			  row--;
        		  }
        		  break;
        	  //行最小即向上到底
        	  case 3 :
        		  if(row < rowMin) {
        			  row = rowMin;
        			  rowMin++;
        			  //向右
        			  k = 0;
        			  col++;
        		  }
        		  break;
        	}
        }
        return ans;
    }
}
