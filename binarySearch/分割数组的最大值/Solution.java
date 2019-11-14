    /**
     * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
注意:
数组长度 n 满足以下条件:
1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
     * @param nums
     * @param m
     * @return
     */
class Solution {
    public int splitArray(int[] nums, int m) {
        long l = 0;
        long r = 0;        
        int n = nums.length;
        //求和
        for (int i = 0; i < n; i++) {
            r += nums[i];
            if (l < nums[i]) {
                l = nums[i];
            }
        }
        long ans = r;
        //判断分组，最小也因为数组中的最大值
        while (l <= r) {
        	//中心值
            long mid = (l + r) >> 1;
            long sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
            	//超过中心值，则为一组
                if (sum + nums[i] > mid) {
                    cnt ++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            //已分组
            if (cnt <= m) {
            	//等于的时候即是最大值
                ans = Math.min(ans, mid);
                //产生的分组少于等于，则为左半边
                r = mid - 1;
            } else {
            	//大于则为右半边
                l = mid + 1;
            }
        }
        return (int)ans;   
    }
}
