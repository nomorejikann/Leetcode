/**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     * @param nums
     * @return
     */
class Solution {
    public int lengthOfLIS(int[] nums) {
       if(nums.length <= 1)
        	return nums.length;
        int r = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1;i < nums.length; i++) {
        	for(int j = 0; j < i; j++) {
        		//区间取最大
        		if(nums[j] < nums[i])
        		  dp[i] = Math.max(dp[j]+1, dp[i]);
        	}
        	r = Math.max(r, dp[i]);
        }
        return r;
    }
}
