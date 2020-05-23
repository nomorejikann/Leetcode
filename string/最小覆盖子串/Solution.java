/**

给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
*/
class Solution {
    public String minWindow(String s, String t) {
        if(s.indexOf(t)>0)
            return t;
        if(s.length()<1)
            return "";
        int[] m=new int[128];
        for(char c:t.toCharArray()){
            m[c]++;
        }
        int c=t.length();
        int b=0;
        int e=0;
        int d=Integer.MAX_VALUE;
        int h=0;
        while(e<s.length()){
            if(m[s.charAt(e++)]-->0)c--;
            while(c==0){
                if(e-b<d){
                    d=e-b;
                    h=b;
                }
                if(m[s.charAt(b)]==0)
                    c++;
                m[s.charAt(b)]++;
                b++;
            }
            
        }
        return d==Integer.MAX_VALUE?"":s.substring(h,h+d);
    }
}
