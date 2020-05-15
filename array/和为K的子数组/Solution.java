/**
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
*/
class Solution {

    public int subarraySum(int[] nums, int k) {
    	if(nums.length==0) return 0;
    	int max=nums[0];
    	int min=nums[0];
    	for(int i=1;i<nums.length;i++){
    		nums[i]+=nums[i-1];
    		max=max>nums[i]?max:nums[i];
    		min=min<nums[i]?min:nums[i];
    	}
    	int count=0;
    	int map[]=new int[max-min+1];
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==k){
    			count++;
    		}
    		if(nums[i]-k>=min&&nums[i]-k<=max){
        		count+=map[nums[i]-k-min];
    		}
    		map[nums[i]-min]++;
    	}
    	return count;
    }
}
