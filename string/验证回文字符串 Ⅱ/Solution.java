/**
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
*/
class Solution {
    public boolean validPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
        
            if(s.charAt(l)!=s.charAt(r))
                return (j(l+1,r,s)||j(l,r-1,s));
            l++;
            r--;
        }
        return true;
        
    }
    
    public boolean j(int l,int r,String s){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
               l++;
               r--;
        }
        return true;
    }
}
