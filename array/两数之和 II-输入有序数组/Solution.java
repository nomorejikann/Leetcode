    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * @param numbers
     * @param target
     * @return
     */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        while(left<right){
            int s=numbers[left]+numbers[right];
            if(s<target)
                left++;
            else if(s>target)
                right--;
            else
                return new int[]{left+1,right+1};
        }
        return new int[]{};
    }
}
