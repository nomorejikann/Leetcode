public class Solution {
  /**
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
    	
        int flag = 0;
        while(b!=0){
            flag = (a&b)<<1;
            a = a^b;
            b = flag;
        }
        return a;
    }
}
