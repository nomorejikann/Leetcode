package backtrace;  
  /**
     * 正则表达式匹配
              给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
	   '.' 匹配任意单个字符
       '*' 匹配零个或多个前面的那一个元素
              所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     */
    int[][] back;
public class Solution {

    public boolean isMatch(String s, String p) {
        back = new int[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    public boolean dp(int i, int j, String t, String p) {
        //完全匹配成功
    	if (j == p.length())
            return i == t.length();
        //已经确定无法匹配
        if (back[i][j] == 1)
            return false;

        boolean firstmatch = i < t.length() && 
        		//匹配一个
        		(t.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        boolean ans;
        //下一个是否为*
        if ((j + 1 < p.length() && p.charAt(j + 1) == '*'))
        	//*后的是否能继续匹配(不匹配*前面一个) || (匹配*前面一个)上一个是否成功&&继续匹配上一个
            ans = dp(i, j + 2, t, p) || (firstmatch && dp(i + 1, j, t, p));
        else
        	//上一个是否成功&&下一个是否成功
            ans= firstmatch && dp(i + 1, j + 1, t, p);
        //匹配失败
        if (ans == false)
        	//所有之后的均为失败
            back[i][j] = 1;

        return ans;
    }
}
