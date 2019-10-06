public class Solution {
	/**
	 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
	 * @param nums
	 * @return
	 */
    public int missingNumber(int[] nums) {

    	//高斯加法
        int sum = ((nums.length+1) * nums.length) / 2;
        int t = 0;
        for(int i : nums)
        	t+=i;
        return sum - t;
    }
}
