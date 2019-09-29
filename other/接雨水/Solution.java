public class Solution {

	public int trap(int[] height) {
		int n = height.length;
		int result = 0;
		if(n == 0 || n == 1) {
			return result;
		}
		//左指针
		int left = 0;
		//右指针
		int right = n - 1;
		
		int leftHeight = 0;
		int rightHeight = 0;
		while(left < right) {
			if(height[left] <= height[right]) {
				//左边最大水位
				leftHeight = Math.max(leftHeight, height[left]);
				result += leftHeight - height[left];
				left++;
			}else {
				//右边最大水位
				rightHeight = Math.max(rightHeight, height[right]);
				//水位差值
				result += rightHeight - height[right];
				right--;
			}
		}
		return result;
	}
