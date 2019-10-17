    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * @param nums
     * @param target
     * @return
     */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
      int rr = 0;
    	if(nums.length <= 3) {
    		for(int i : nums)
    			rr+=i;
    		return rr;
    	}
    	Arrays.sort(nums);
    	int pre = 0x7fffffff;
    	for(int i = 0; i < nums.length; i++) {
    		int left = i+1;
    		int right = nums.length - 1;
        //逼近
    		while(left < right) {
    			int sum = nums[i] + nums[left] + nums[right];
    			int t = target - sum;
    			if(sum > target) 
    				right--;
    			else if(t == 0)
    				return target;
    			else
    				left++;
            //有负数
    			if(Math.abs(pre) > Math.abs(t)) {
    				pre = t;
    				rr = sum;
    			}
    		}
    	}
    	return rr;
    }
}
