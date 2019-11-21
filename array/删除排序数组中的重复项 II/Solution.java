
class Solution {
    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length < 1)
    		return 0;
    	//计数
    	int c = 0, j = 0;
    	for(int i = 1; i < nums.length;i++) {
    		if(nums[j] == nums[i]){
    			c++;
    			if(c < 2) 
    				nums[++j] = nums[i];
    		}else {
    			nums[++j] = nums[i];
    			//初始化
    			c = 0;
    		}
    	}
    	return j+1;
    }
}
