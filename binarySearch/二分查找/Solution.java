/**
给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1&&nums[0]==target)
            return 0;
        int l=0;
        int r=nums.length;
        while(l<r){
             int mid=l+(r-l)/2;
            if(nums[mid]<target)
               l=mid+1;
            else if(nums[mid]>target)
               r=mid;
            else
                return mid;

        }
        return -1;
    }
}
