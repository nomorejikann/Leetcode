/**
给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
*/
class Solution {
    public String shortestPalindrome(String s) {
        int i=s.length();
        for(;i>0;i--)
            if(p(s.substring(0,i)))
                break;
        return new StringBuilder(s.substring(i,s.length())).reverse().toString()+s;
    }
    public boolean p(String s){
        for(int i=0;i<s.length()/2;i++)
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        return true;
    }
}
