	/**
	 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
返回仅包含 1 的最长（连续）子数组的长度
	 * @param A
	 * @param K
	 * @return
	 */
class Solution {
    public int longestOnes(int[] A, int K) {
        int max = 0;
        //窗口左边界
        int l = 0;
        //窗口右边界
        int r = 0;
        //窗口的0总数
        int count = 0;
        while(r < A.length) {
        	if(A[r] == 0)
        		count++;
        	while(count > K) {
        		if(A[l++] == 0)
        			count--;
        	}
        	max = Math.max(max, r-l+1);
        	r++;
        }
        return max;
    }
}
