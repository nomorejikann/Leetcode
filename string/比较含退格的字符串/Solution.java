/**
给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(c == '#' && s.length()>0 )
              s.deleteCharAt(s.length()-1);
            else if(c != '#')
              s.append(c);
        }

        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            if(c == '#' && t.length()>0 )
              t.deleteCharAt(t.length()-1);
            else if(c != '#')
              t.append(c);
        }

        return s.toString().equals(t.toString());
    }
}
