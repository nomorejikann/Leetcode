    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
注意：
答案中不可以包含重复的四元组。
     * @param nums
     * @param target
     * @return
     */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length <= 3)
        	return ans;
        //排序去重
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length-3; i++) {
    		//去重
    		if(i > 0 && nums[i] == nums[i-1])
    			continue;
    		for(int j = i+1; j < nums.length-2; j++) {
    			if(j > i+1 && nums[j] == nums[j-1])
    				continue;
    			int l = j+1;
    			int r = nums.length -1;
    			//双指针n^3
    			while(l < r) {
    				int  t = nums[i] + nums[j] + nums[l] + nums[r];
    				if(t == target) {
    					List<Integer> list = new ArrayList<>();
    					list.add(nums[i]);
    					list.add(nums[j]);
    					list.add(nums[l]);
    					list.add(nums[r]);
    					ans.add(list);
    					l++;
    					r--;
    					//去重
    					while(l < r && nums[l] == nums[l-1]) l++;
    					while(l < r && nums[r] == nums[r+1]) r--;
    				}else if(t > target) {
    					r--;
    					while(l < r && nums[r] == nums[r+1]) r--;
    				}else {
    					l++;
    					while(l < r && nums[l] == nums[l-1]) l++;
    				}
    			}
    		}
    	}
    	return ans;
    }
}
