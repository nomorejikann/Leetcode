/**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
     * @param s
     * @param nums
     * @return
     */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int slow = 0;
        int fast = 1;
        if(nums.length < 1)
        	return 0;
        int sum = nums[slow];
        int r = 0x7fffffff;
        while(slow < fast) {
        	if(sum < s) {
        		if(fast > nums.length-1)
        			break;
        		sum += nums[fast++];
        	}else {
        		r = Math.min(r, fast - slow);
        		sum -= nums[slow++];
        	}
        }
        return r == 0x7fffffff ? 0 : r;
    }
}
