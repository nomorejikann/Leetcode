/**
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
        int[] temp=new int[len];
        for(int i=0;i<nums1.length;i++){
            temp[i]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            temp[i+nums1.length]=nums2[i];
        }
        Arrays.sort(temp);
        if(len%2==1)
            return temp[len/2];
        return (temp[len/2-1]+temp[len/2])/2.0;
    }
}
