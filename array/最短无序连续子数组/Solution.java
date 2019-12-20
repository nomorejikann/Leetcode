/**
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。\
你找到的子数组应是最短的，请输出它的长度。
*/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min=0x7fffffff;
        int max=0x80000000;
        for(int i=1;i<nums.length;i++)
            if(nums[i]<nums[i-1])
                min=Math.min(min,nums[i]);
        for(int i=nums.length-2;i>=0;i--)
            if(nums[i]>nums[i+1])
                max=Math.max(max,nums[i]);
        int l=0,r;
        for(;l<nums.length;l++)
            f(nums[l]>min)
                break;
        r=nums.length-1;
        for(;r>=0;r--)
            if(nums[r]<max)
                break;
       return r-l<0?0:r-l+1;
    }
    
}
