/**

给你一个整数数组 nums，请你将该数组升序排列。
*/
class Solution {
    public int[] sortArray(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (min > nums[i]) min = nums[i];
            else if (max < nums[i]) max = nums[i];
        }
        int range = max - min + 1;
        
        int[] counts = new int[range];
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] - min]++;
        }
        for (int i = 0, j = 0; i < range; i++) {
            while (counts[i]-- > 0) {
                nums[j++] = i + min;
            }
        }
        return nums;
    }
}
