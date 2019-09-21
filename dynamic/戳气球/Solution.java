class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        //计算数组
        int[] temp = new int[len + 2];
        //nums[-1] = nums[n] = 1
        temp[0] = temp[len + 1] = 1;
        for (int i = 1; i < len + 1; i++) {
            temp[i] = nums[i - 1];
        }
        int[][] dp = new int[len + 2][len + 2];
        //范围
        for (int k = 1; k <= len; k++) {
            //搜索位置起始
        	for (int i = 1; i <= len - k + 1; i++) {
                //搜索上限
        		int j = i + k - 1;
                //开始搜索
        		for (int p = i; p <= j; p++) {
        			//左+右+当前
                    dp[i][j] = Math.max(dp[i][j], dp[i][p - 1] + dp[p + 1][j] + temp[i - 1] * temp[p] * temp[j + 1]);
                }
            }
        }
        return dp[1][len];


    }
}
