    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     * @param nums
     * @param S
     * @return
     */
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return rec(nums, S, 0);
    }
    //递归
    public int rec(int[] nums, int target, int start) {
    	//是否有解
    	if(start == nums.length) 
    		return target == 0 ? 1 : 0;
    	else 
    		//分别求解
    		return rec(nums, target-nums[start], start+1) + rec(nums, target+nums[start], start+1);
    }
}
