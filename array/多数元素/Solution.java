/**
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

*/
class Solution {
    public int majorityElement(int[] nums) {
            	int count = 1;
        int result = nums[0];
        for (int i=1; i<nums.length; i++) {
            
        	if (count==0) {
                result = nums[i];
                count = 1;
                continue;
            }
           
            if (nums[i] == result) {
                count++;
            
            } else {
                count--;
            }
        }
        return result;
    }
}
