	/**
	 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
	 * @param words
	 * @return
	 */
class Solution {

public List<List<Integer>> palindromePairs(String[] words) {
		//保存字符对应的位置
		Map<String, Integer> map = new HashMap<>();
		List<List<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < words.length; i++)
			map.put(words[i], i);
		for (int i = 0; i < words.length; i++) {
			int l = 0;
			int r = 0;
			while (l <= r) {
				//前半/后半||0->r/l->r
				String s = words[i].substring(l, r);
				//尝试找到对应的回文
				Integer j = map.get(new StringBuilder(s).reverse().toString());
				if (j != null && j != i &&
						//l=0则剩余的未对应字符串(后半)为r->end否则为0->l
						isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l))) {
					
					ans.add(l == 0 ? Arrays.asList(new Integer[] { i, j }) : Arrays.asList(new Integer[] { j, i }));
				}
				if (r < words[i].length())
					r++;
				else
					l++;
			}
		}
		return ans;

	}

	public boolean isPalindrome(String s) {

		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;

		}
		return true;

	}

}
