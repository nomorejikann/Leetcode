/**
给定一个无序的整数数组，找到其中最长上升子序列的长度。
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length<1)
            return 0;
        int[] dp=new int[nums.length];
        int r=1;
        Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            r=Math.max(r,dp[i]);
        }
        return r;
    }
}
