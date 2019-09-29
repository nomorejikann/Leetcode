	/**
	 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在众数。
	 * @param nums
	 * @return
	 */
class Solution {
    public int majorityElement(int[] nums) {
            	int count = 1;
        int result = nums[0];
        for (int i=1; i<nums.length; i++) {
            //因为要大于n/2出现次数，所以count总会最低多一
        	if (count==0) {
                result = nums[i];
                count = 1;
                continue;
            }
            //计算重复，找出重复最多的那一个
            if (nums[i] == result) {
                count++;
            //否则重复次数减少一
            } else {
                count--;
            }
        }
        return result;
    }
}
