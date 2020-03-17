/**
给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。

假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。

注意：每次拼写时，chars 中的每个字母都只能用一次。

返回词汇表 words 中你掌握的所有单词的 长度之和。

 */
 class Solution {
    public int countCharacters(String[] words, String chars) {
        if(chars.length()<1)
            return 0;
        int[] m=new int[26];
        int ans=0;
        for(char c:chars.toCharArray())
            m[c-'a']++;
        z:for(String s:words){
            int[] t=m.clone();
            for(char c:s.toCharArray()){
                t[c-'a']--;
                if(t[c-'a']<0)
                    continue z;
            }
            ans+=s.length();
        }
        return ans;
    }
}
