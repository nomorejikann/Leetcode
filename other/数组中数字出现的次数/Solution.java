/**
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
*/
class Solution {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum ^=num;
        }

        int flag = sum&(-sum);
        int res1 = 0;
        for(int val:nums){
            if((flag&val)!=0){
                res1 ^=val;
            }
        }

        return new int[]{res1,res1^sum};
    }
}
