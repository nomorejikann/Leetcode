/**
给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。

形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
*/
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int item : A) { //
            sum += item;
        }
        int data = sum / 3;
        int start = 0;
        int lsum = 0;
        while (start < A.length - 1 && lsum != data) {
            lsum += A[start];
            ++start;
        }
        int end = A.length - 1;
        int rsum = 0;
        while (end >= 0 && rsum != data) {
            rsum += A[end];
            --end;
        }
        return start <= end && (sum - lsum - rsum) == data;
    }
}
