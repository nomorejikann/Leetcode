    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * @param nums
     * @return
     */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c = 0;
        int r = 0;
        for(int i : nums) 
        	if(i==1) {
        		c++;
        	}
        	else {
        	    r = Math.max(r, c);
        	    c=0;
        	}
        return r;
    }
}
