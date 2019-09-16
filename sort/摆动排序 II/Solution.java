package sort;
	/**
	 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
	 * @param nums
	 */
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.sort(nums);
        //奇数从倒数第一个开始，偶数则第二个
        int right = (len%2 == 1) ? len-1 : len-2;
        int left = 1;
        int mid = nums[len/2];
        
        for(int i = len-1; i > 0 && left < len && nums[i] >= mid; i--, left+=2){
            //奇数，逆序保证最大在最左
        	ans[left] = nums[i];
        }
        for(int i = 0; i < len && right >= 0 && nums[i] <= mid; i++, right-=2){
           //偶数，正序保证最大在最左
        	ans[right] = nums[i];
        }
        for(int i = 0; i < len; i++){
            nums[i] = ans[i];
        }
    }
}
