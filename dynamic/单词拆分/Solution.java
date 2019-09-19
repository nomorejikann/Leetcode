public class Solution{
  /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
说明：
拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
    	int len = s.length();
        boolean[] dp = new boolean[len+1];
        //初始化
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
        	for(int j = 0; j < i; j++) {
        		//abcde  ab,cde  a=false ab=true c=false cd=false cde=true
        		if(dp[j] && wordDict.contains(s.substring(j, i))) {
        			//保存状态
        			dp[i] = true;
        			break;
        		}
        	}
        }
        return dp[len];
    }
}
