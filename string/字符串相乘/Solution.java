    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * @param num1
     * @param num2
     * @return
     */
class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 == 0 || len2 == 0 || num1.charAt(0) == '0' || num2.charAt(0) == '0')
        	return "0";
        int[] ans = new int[len1 + len2];
        //个位开始计算
        for(int i = len1 - 1; i >= 0; i--) {
        	int n1 = num1.charAt(i) - '0';
        	for(int j = len2 - 1; j >= 0; j--) {
        		int n2 = num2.charAt(j) - '0';
        		//当前的结果加上之前计算的结果
        		int sum = n1 * n2 + ans[i+j+1];
        		//去掉进位
        		ans[i+j+1] = sum%10;
        		//累加进位
        		ans[i+j] += sum/10;
        	}
        }
        StringBuilder sb = new StringBuilder();
        //去掉首位0
        int i = ans[0] == 0 ? 1:0;
        for(; i < ans.length; i++) 
        	sb.append(ans[i]);
        return sb.toString();
    }
}
