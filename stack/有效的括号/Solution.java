    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * @param s
     * @return
     */
class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
    	int idx = 0;
    	for(char c : s.toCharArray()) {
      //入栈
    		if(c == '(' || c =='{' || c == '[') {
    			stack[idx++] = c;
          //出栈且不能为空
    	    }else if(--idx < 0 || (c==')'&&stack[idx] != '(') || (c =='}'&& stack[idx] != '{') 
    				|| (c==']' && stack[idx] != '['))
    			return false;
    	    
    	}
      //是否匹配完成
    	return idx == 0;
    }
}
