    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
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
         for(StringBuilder t : l)
        	 //正向添加反转的单词
        	 sb.append(t.reverse()).append(" ");
         //去除最后一个多余的空格
         return sb.deleteCharAt(sb.length()-1).toString();
    }
}
