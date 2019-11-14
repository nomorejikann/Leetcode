/**
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
给出两个整数 x 和 y，计算它们之间的汉明距离。
注意：
0 ≤ x, y < 231.
*/
class Solution {
    public int hammingDistance(int x, int y) {
        //要计算的值
        x = x ^ y;
        y = 0;
        while(x != 0){
            //自身-1&自身即等于去掉了一位1
            x &=(x-1);
            y++;
        }
        return y;
    }
}
