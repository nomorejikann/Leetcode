/**
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

*/
class Solution {
    public int[][] findContinuousSequence(int N) {
        //m项 首项为x 差为1 等差数列和为N, (x + x + m - 1)*m/2 = N
        //移项 (2x + m - 1)*m = 2*N
        //整理 x = (2 * N + m * (1 - m))/(2 * m) > 0, x为正整数
        List<int[]> res = new ArrayList<>();
        for (int m = 1; 2*N-m*m+m>0; m++) {
            int remainder = (2*N-m*m+m)%(2*m);
            if (remainder == 0 && m != 1) {//we r not adding the single N
                int[] arr = new int[m];
                arr[0] = (2 * N + m * (1 - m))/(2 * m);//递推填充
                for(int i = 1; i < m; i++) arr[i] = arr[i-1] + 1;
                res.add(0,arr);//头插逆序
            }
        }
        return res.toArray(new int[0][]);
    }
}
