class Solution {
    /**
     * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
说明：
分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
    	List<String> ans = new ArrayList<>();
        boolean[] dp = new boolean[len+1];
        //初始化
        dp[0] = true;
        //快速去除不合格的
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
        if(!dp[len])
        	return ans;
        dfs(ans,"",s,0,0,wordDict);
        return ans;
    }
    public void dfs(List<String> ans, String p, String s, int len, int start, List<String> dict) {
    	if(len > s.length())
    		return;
    	if(len == s.length()) {
    		ans.add(p.trim());
    		return;
    	}
    	//从头开始遍历
    	for(int i = start+1; i <= s.length(); i++) {
    		//截断
    		String t = s.substring(start, i);
    		if(dict.contains(t)) 
    			dfs(ans,p+t+" ",s,len+t.length(),i,dict);
    		
    		
    	}
    }
}
