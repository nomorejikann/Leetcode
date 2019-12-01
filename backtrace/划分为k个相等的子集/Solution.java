class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i : nums)
        	sum += i;
        //无法求出平均值
        if(sum % k != 0)
        	return false;
        Arrays.sort(nums);
        int average = sum / k;
        //大于平均值
        if(nums[nums.length-1] > average)
        	return false;
        return backtrace(new int[k], nums, nums.length-1, average);
    }
    
    public boolean backtrace(int[] ans, int[] nums, int end, int average) {
    	//求和完毕
    	if(end < 0)
    		return true;
    	//最高位依次求和
    	int t = nums[end--];
    	for(int i = 0; i < ans.length; i++) {
    		//符合要求的和
    		if(ans[i] + t <= average) {
    			ans[i] += t;
    			if(backtrace(ans, nums, end, average))
    				return true;
    			//回溯
    			ans[i] -= t;
    		}
    		//无值可用不满足K个子集
    		if(ans[i] == 0)
    			break;
    	}
    	return false;
    }
}
