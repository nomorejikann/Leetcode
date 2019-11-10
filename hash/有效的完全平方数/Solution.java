/**
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
说明：不要使用任何内置的库函数，如  sqrt。
*/
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while(num>0){
            num -= i;
            //完全平方数的性质：必然为奇数之和
            i += 2;
        }
        return num == 0;

    }
}
