	/**
	 * 给定两个数组，编写一个函数来计算它们的交集。
	 * @param nums1
	 * @param nums2
	 * @return
	 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        for(Integer i : nums1)
        	s1.add(i);
        Set<Integer> s2 = new HashSet<>();
        for(int i : nums2)
        	if(s1.contains(i))
        		s2.add(i);
        int[] ans = new int[s2.size()];
        int i = 0;
        for(int j : s2)
        	ans[i++] = j;
        return ans;
    }
}
