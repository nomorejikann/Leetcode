    /**
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     * 输入: "the sky is blue"
	      输出: "blue is sky the"
     * @param s
     * @return
     */
class Solution {
    public String reverseWords(String s) {
        if("".equals(s.trim()))
        	return "";
        StringBuilder sb = new StringBuilder();
        List<StringBuilder> l = new ArrayList<>();
        //添加最后一个单词
        s += " ";
        for(char c : s.toCharArray()) {
        	if(c == ' ') {
        		if(!"".equals(sb.toString()))
        		  l.add(sb);
        		sb = new StringBuilder();
        	}else {
        		sb.append(c);
        	}
        }
        sb = new StringBuilder();
        //反向添加
        for(int i = l.size()-1; i>= 0; i--)
        	sb.append(l.get(i)).append(" ");
        //去除最后一个多余的空格
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
