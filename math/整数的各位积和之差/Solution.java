/**
给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
*/
class Solution {
    public int subtractProductAndSum(int n) {
        int p = 1;
        int q = 0;
        while(n > 0){
            int t = n % 10;
            n /= 10;
            p *= t;
            q += t;
        }
        return p -q;
    }
}
