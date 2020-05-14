/**

给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
*/
class Solution {
    public int singleNumber(int[] nums) {
        int a=1;
        for(int i:nums)
            a^=i;
        return a^1;
    }
}
