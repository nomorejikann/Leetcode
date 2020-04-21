/**
给你一个整数数组 nums 和一个整数 k。

如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。
*/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
 
        int res = 0, sum = 0;
        for (int num: nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }       
        }
        return res;
    }
}
