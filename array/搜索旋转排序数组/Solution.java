/**
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

*/
class Solution {
    int index;
    public int search(int[] nums, int target) {
        if(nums.length == 0)return -1;
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    public int binarySearch(int[] nums, int left, int right, int target){
        if(left > right)return -1;
        int mid = left + (right - left) / 2;
        if(nums[mid] == target)return mid;
        if(nums[left] <= nums[mid]){
            if(nums[left] <= target && target <= nums[mid]){
                return binarySearch(nums, left, mid, target);
            }
            else return binarySearch(nums, mid + 1, right, target);
        }
        else{
            if(nums[mid] <= target && target <= nums[right]){
                return binarySearch(nums, mid, right, target);
            }
            else return binarySearch(nums, left, mid - 1, target);
        }
    }
}
