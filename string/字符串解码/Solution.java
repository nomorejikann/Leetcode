    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * @param s
     * @return
     */
class Solution {
    public String decodeString(String s) {
        //次数
        Stack<Integer> times = new Stack<>();
        //上一层
        Stack<StringBuilder> pre = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for(char c : s.toCharArray()) {
        	if(Character.isDigit(c)) {
        		count = count * 10 + (c - '0');
        	//添加上一级的
        	}else if(c == '[') {
        		
        		times.push(count);
        		pre.push(ans);        		
        		//初始化
        		count = 0;
        		ans = new StringBuilder();
        	//计算
        	}else if(c == ']') {
        		StringBuilder sb = new StringBuilder();
        		if(!pre.isEmpty())
        			sb = pre.pop();
        		int k = times.pop();
        		for(int i = 0; i < k; i++) 
        			sb.append(ans);
        		ans = sb;
        	}else {
        		ans.append(c);
        	}
        }
        return ans.toString();
    }
}
