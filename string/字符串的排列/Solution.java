    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
换句话说，第一个字符串的排列之一是第二个字符串的子串。
     * @param s1
     * @param s2
     * @return
     */
class Solution {
   public boolean checkInclusion(String s1, String s2) {
    	if(s1.length() > s2.length())
    		return false;
    	int[] m1 = new int[26];
    	int[] m2 = new int[26];
    	char[] c1 = s1.toCharArray();
    	char[] c2 = s2.toCharArray();
    	//添加s1长度的值
    	for(int i  = 0; i < c1.length; i++) {
    		m1[c1[i]-'a']++;
    		m2[c2[i]-'a']++; 
    	}
    	//差值
    	for(int i  = 0; i < c2.length - c1.length; i++) {
    		if(match(m1,m2))
    			return true;
    		//去掉当前
    		m2[c2[i]-'a']--;
    		//增加s1长度之后的值
    		m2[c2[i+c1.length]-'a']++;
    	}
    	return match(m1,m2);
    }
    
    private boolean match(int[] a, int[] b) {
        for (int i=0; i<a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
