package sort;

public class Solution {
  /**
     * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
       请注意，它是排序后的第k小元素，而不是第k个元素。
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
    	int n = matrix.length;
        int lo = matrix[0][0], hi = matrix[n-1][n-1];
        while(lo < hi) {
        	//二分
            int mid = lo + (hi - lo) / 2;
            //计数
            int count = 0,  j = n - 1;
            for(int i = 0; i < n; i++) {
                //逼近
            	while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            //二分小于计数
            if(count < k) 
        //+1
		lo = mid + 1;
            //二分大于计数
            else 
		hi = mid;
        }
        return lo;
    }
}
