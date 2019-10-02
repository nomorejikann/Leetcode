    /**
     * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
输入:
s = "aaabb", k = 3
     * @param s
     * @param k
     * @return
     */
class Solution {
    public int longestSubstring(String s, int k) {
        return divd(s, k, 0 , s.length());
    }
    //分治
    public int divd(String s, int k, int start, int end) {
    	if(start >= end)
    		return 0;
    	//保存出现次数
    	int[] map = new int[26];
    	for(int i = start; i < end; i++)
    		map[s.charAt(i)-'a']++;
    	//26个字母
    	for(int i = 0; i < 26; i++) {
    		//找出不满足的点
    		if(map[i] > 0 && map[i] < k) {
    			int pos = s.indexOf((char)(i+'a'), start);
    			//left right 分治
    			return Math.max(divd(s, k, start, pos), divd(s, k, pos+1, end));
    		}
    	}
    	
    	return end - start;
    }
}
