    /**
     * 在一个给定的数组nums中，总是存在一个最大元素 。
查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
如果是，则返回最大元素的索引，否则返回-1。
     * @param nums
     * @return
     */
class Solution {
    public int dominantIndex(int[] nums) {
        int ret = -1;
    	int max = Integer.MIN_VALUE;
    	for(int i = 0; i < nums.length; i++) {
    		if(max < nums[i]) {
    			max = nums[i];
    			ret = i;
    		}
    	}
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(nums[i] != 0 && i != ret && max / nums[i] < 2)
    			return -1;
    	}
    	return ret;
    }
}
