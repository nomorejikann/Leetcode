/**
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
     * @param nums
     * @return
*/
class Solution {
    public int arrayPairSum(int[] nums) {
        int r=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i%2==0)
                r+=nums[i];
        }
        return r;
    }
}
