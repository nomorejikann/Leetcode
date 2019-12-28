/**
给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
*/
class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int i : nums){
            if((i+"").length() % 2 == 0)
              ans++;
        }
        return ans;
    }
}
