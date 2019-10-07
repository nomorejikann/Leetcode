    /**
     * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * @param nums
     * @return
     */
class Solution {
    public int pivotIndex(int[] nums) {
        //左边和
    	int lsum = 0;
        //右边和
    	int rsum = 0;
        for(int i = 1; i < nums.length; i++)
        	rsum += nums[i];
        for(int i = 0; i < nums.length; i++) {
        	if(lsum == rsum)
        		return i;
        	//缺少中心索引
        	if(i == nums.length -1)
        		return -1;
        	//左边累加
        	lsum += nums[i];
        	//右边减去,i+1为中心索引
        	rsum -= nums[i+1];

        }
        return -1;
    }
}
