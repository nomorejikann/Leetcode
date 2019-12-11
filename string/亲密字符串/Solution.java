/**
给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
*/
class Solution {
    public boolean buddyStrings(String A, String B) {
        int len=A.length();
        if(len!=B.length()||len<1)
            return false;
        int a=0;
        int b=len-1;
        int c=0;
        for(int i=0;i<len;i++){
            if(A.charAt(i)!=B.charAt(i)){
                c++;
            if(c==1)
                a=i;
            else if(c==2)
                b=i;
            else
                return false;
            }
        }
        c=0;
        if(A.equals(B)){
            for(int i='a';i<'z';i++)
                if(A.indexOf((char)i)!=A.lastIndexOf((char)i))
                    c=i;

        }
        return A.charAt(a)==B.charAt(b)&&A.charAt(b)==B.charAt(a)||c>0;
    }
}
