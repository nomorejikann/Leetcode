/**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     * @param nums
     * @param k
     * @return
     */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	List l = map.getOrDefault(nums[i], new ArrayList<>());
        	l.add(i);
        	map.put(nums[i], l);
        }
        
        for(List<Integer> l : map.values()) {
        	for(int i = 0; i < l.size()-1; i++) {

        		if(Math.abs(l.get(i+1)-l.get(i)) <= k)
        			return true;
        	}
        }
        return false;	
    }
}
