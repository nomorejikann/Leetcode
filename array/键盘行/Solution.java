/**
给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
*/
class Solution {
    public String[] findWords(String[] words) {
        List<String> l=new ArrayList<>();
        z:for(String s:words){
            int idx=getIdx(s.charAt(0));
            for(char c:s.toCharArray()){
                if(idx!=getIdx(c))
                    continue z;

            }
            l.add(s);
        }
        return l.toArray(new String[l.size()]);
    }
    public int getIdx(char c){
        if("qwertyuiopQWERTYUIOP".indexOf(c)!=-1)
            return 1;
        else if("asdfghjklASDFGHJKL".indexOf(c)!=-1)
            return 2;
        else
            return 3;
}
}
