package dynamic;

public class Solution {

	/**
     * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
    	
    	//乘积
        int a = 1;
        //最大值
        int max = 0;
        //从前向后
        for(int i : nums) {
        	a *= i;
        	if(max < a)
        		max =a;
        	//遇0则初始化
        	if(i == 0)
        		 a = 1;
        }
        //初始化
        a = 1;
        //从后向前
        for(int i = nums.length-1;i>=0;i--) {
        	a *= nums[i];
        	if(max < a)
        		max =a;
        	//遇0则初始化
        	if(nums[i] == 0)
        		 a = 1;
        }
       
        return max;
    }
}
