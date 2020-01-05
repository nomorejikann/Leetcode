/**
给定一个正整数 n，你可以做如下操作：
1. 如果 n 是偶数，则用 n / 2替换 n。
2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
n 变为 1 所需的最小替换次数是多少？
*/
class Solution {
    public int integerReplacement(int n) {
        int[] bits = new int[32];
        int max = 0;
        //统计每一位上为1还是为0,0代表偶数可以直接右移，1代表需要加1或者减1的操作
        for (int i = 0; i < 31; i++) {
            bits[i] = n & 1;
            n >>= 1;
            if (bits[i] == 1) {
                max = i;
            }
        }
        int count = 0;
        for (int i = 0; i < max; i++) {
            //无论是0还是1，至少需要一步操作，0为直接右移，1为加1或者减1
            count++;
            if (bits[i] == 1) {
                int oneNum = 1;
                while (i + 1 <= max && bits[i + 1] == 1) {
                    i++;
                    oneNum++;
                }
                //连续的1的个数大于1，则选择加1的操作，并将前一位置1；否则选择减1的操作
                if (oneNum > 1) {
                   bits[i + 1] = 1;
                }
                count += oneNum;
                //唯一的特殊情况，当最高位存在连续两个1，即最后剩下11（3）的时候，此时用减1的操作只需要两步，但上面加了三步，需要减一
                if (oneNum == 2 && i == max) count--;
            }
        }
        return count;
    }
}
