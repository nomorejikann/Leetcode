/**
给出两个图像 A 和 B ，A 和 B 为大小相同的二维正方形矩阵。（并且为二进制矩阵，只包含0和1）。

我们转换其中一个图像，向左，右，上，或下滑动任何数量的单位，并把它放在另一个图像的上面。之后，该转换的重叠是指两个图像都具有 1 的位置的数目。

（请注意，转换不包括向任何方向旋转。）

最大可能的重叠是什么？
*/
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int[][] count = new int[2*N+1][2*N+1];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if (A[i][j] == 1)
                    for (int i2 = 0; i2 < N; ++i2)
                        for (int j2 = 0; j2 < N; ++j2)
                            if (B[i2][j2] == 1)
                                count[i-i2 +N][j-j2 +N] += 1;

        int ans = 0;
        for (int[] row: count)
            for (int v: row)
                ans = Math.max(ans, v);
        return ans;
    }
}
