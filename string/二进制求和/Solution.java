	/**
	 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
输入为非空字符串且只包含数字 1 和 0。
	 * @param a
	 * @param b
	 * @return
	 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        //进位
        int c = 0;
        for(int i = a.length()-1, j = b.length()-1; i >=0 || j >= 0; i--,j--) {
        	int p = 0;
        	if(i >= 0)
        		p = a.charAt(i) -'0';
        	int q = 0;
        	if(j >= 0)
        		q = b.charAt(j) - '0';
        	int r = p + q + c;
        	if(r >= 2) {
        		c = 1;
        		r-=2;
        	}else {
        		c = 0;
        	}
        	sb.append(r);
        }
        if(c > 0)
        	sb.append("1");
        //正序相加，逆序输出
        return sb.reverse().toString();
    }
}
