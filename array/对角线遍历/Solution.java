    /**
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]
     * @param matrix
     * @return
     */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int rowMax = matrix.length;
        if(rowMax < 1)
        	return new int[] {};
        int colMax = matrix[0].length;
    	int row = 0;
        int col = 0;
        //向下，向上
        int[][] dir = {{-1,1},{1,-1}};
        //方向
        int k = 0;
        int[] ans = new int[rowMax * colMax];
        for(int i = 0; i < ans.length; i++) {
        	ans[i] = matrix[row][col];
        	row += dir[k][0];
        	col += dir[k][1];
        	//遇到顶点
        	if(row >= rowMax) {
        		row = rowMax - 1;
        		col += 2;
        		k -= 1;
        	}
        	
        	if(col >= colMax) {
        		col = colMax - 1;
        		row += 2;
        		k += 1;
        	}
        	
        	if(row < 0) {
        		row = 0;
        		k += 1;
        	}
        	
        	if(col < 0) {
        		col = 0;
        		k -= 1;
        	}
        }
        return ans;
    }
}
