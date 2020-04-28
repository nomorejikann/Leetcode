/**
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
*/
class Solution {
    public int[] singleNumbers(int[] nums) {
        int a = 0;
        for(int i : nums)
          a ^= i;
        int b = 1;
        while((b & a) == 0)
         b <<= 1;
        int[] ans = new int[2];
        for(int i : nums)
          if((b&i)==0)
          ans[0] ^= i;
          else
          ans[1] ^= i;
          return ans;
    }
}
