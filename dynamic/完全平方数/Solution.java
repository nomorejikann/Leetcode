public class Solution{
  /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * @param n
     * @return
     */
    public int numSquares(int n) {
    	int[] dp = new int[n+1];
    	//0为0，平方数也为0
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
        	dp[i] = i;
        	//dp[2]=dp[1]+1;dp[4]=dp[0]+1;dp[5]=dp[4]+1;
        	for(int j = 1; j *j <= i; j++) 
        		dp[i] = Math.min(dp[i], dp[i-j*j]+1);
        }
        return dp[n];
    }
}
