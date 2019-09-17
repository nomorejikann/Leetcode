public class Solution {
  /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
       请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
       你可以假设 nums1 和 nums2 不会同时为空。
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length,i1 = 0, m1 = 0, m2 = 0,
        		i2 = 0, pre = 0,  cur = 0;
        //因为已经是有序，所以直接找到中间值就可以了
        while(i1+i2 < len/2) {
        	//保存上一个
        	pre = cur;
        	//初始化n1数据，避免达到最长后n2指针不会继续增加
        	m1 = Integer.MAX_VALUE;
        	if(i1 < nums1.length)
        		m1 = nums1[i1];
        	//初始化n2数据，避免达到最长后n1指针不会继续增加
        	m2 = Integer.MAX_VALUE;
        	if(i2 < nums2.length)
        		m2 = nums2[i2];
        	//n1<n2
        	if(m1 < m2) {
        		//n1指针++
        		i1++;
        		//更新当前值
        		cur = m2;
        	}
        	else {
        		//n2指针++
        		i2++;
        		//更新当前值
        		cur = m1;
        	}
        }
        //长度为奇数则直接返回中间值
        if(len % 2 == 1)
        	return cur;
        //偶数则中间相加/2
        return (pre+cur)/2.0;
    }
}
