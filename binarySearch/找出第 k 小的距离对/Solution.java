    /**
     * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.
     * @param nums
     * @param k
     * @return
     */
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int h = nums[nums.length-1] - nums[0];
        while(l < h){
            //中间值
            int mid = l + (h - l)/2;
            
            int count = 0, start = 0;
            //遍历整个长度
            for(int i = 0; i < nums.length; i++){
                //大于mid则从下一个比较
                while(nums[i] - nums[start] > mid) start++;
                //计算小于mid的总数
                count += i - start;
            }
            //符合条件
            if(count >= k)
                h = mid;
            else
                l = mid+1;
        }
        return l;
    }
}
