/**
给定一个 没有重复 数字的序列，返回其所有可能的全排列。
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		backtracking(nums, list, result);
		return result;
    }
    
    public void backtracking(int[] a, List<Integer> list, List<List<Integer>> result) {
		if (list.size() == a.length) {
			result.add(new ArrayList<>(list));
		} else {
			for (int i = 0; i < a.length; i++) {
				if (list.contains(a[i]))
					continue;
				list.add(a[i]);
				backtracking(a, list, result);
				list.remove(list.size() - 1);
			}
		}

	}
}
