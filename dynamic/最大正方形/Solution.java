    /**
     * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
     * @param matrix
     * @return
     */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] len = new int[m+1][n+1];
        int max = 0;
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if (matrix[i-1][j-1]=='1') {
                	//之前最短边,当前边
                    len[i][j] = Math.min(len[i-1][j-1], Math.min(len[i-1][j], len[i][j-1])) + 1;;
                }
                //最长边
                max = Math.max(max, len[i][j]);
            }
        }
        return max*max;
    }
}
