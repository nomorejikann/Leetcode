package backtrace;

public class Solution {
	/**
	 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
     '?' 可以匹配任何单个字符。
     '*' 可以匹配任意字符串（包括空字符串）。
          两个字符串完全匹配才算匹配成功。
	 * @param s
	 * @param p
	 * @return
	 */
    public boolean isMatch(String s, String p) {
        int ss = 0, ps = 0, idx = -1, matched = 0;
        //匹配
        while(ss < s.length()){
        	//单个匹配成功
          if(ps < p.length() && 
        		  (s.charAt(ss)==p.charAt(ps) || p.charAt(ps)=='?')) {
        	  ss++;
        	  ps++;
          }
          //匹配任意字符
          else if(ps<p.length()&&p.charAt(ps)=='*') {
        	  //*的位置
        	  idx=ps;
        	  //任意字符匹配起点
        	  matched=ss;
        	  //继续匹配下一个
        	  ps++;
          }
          //回溯
          else if(idx != -1) {
        	  //匹配*的下一个
        	  ps = idx+1;
        	  //通过*匹配成功
        	  matched++;
        	  ss = matched;
          //回溯过后依然无法匹配
          }else {
        	  return false;
          }
        }
        //s:acbe
        //p:a*b***
        while(ps < p.length() && p.charAt(ps) == '*') ps ++;
        //是否完全匹配
        return ps == p.length();
    }
}
