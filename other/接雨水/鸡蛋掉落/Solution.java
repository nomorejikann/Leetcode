	/**
	 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。
每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。
你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。
每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。
你的目标是确切地知道 F 的值是多少。
无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
1 <= K <= 100
1 <= N <= 10000
	 * @param K
	 * @param N
	 * @return
	 */
class Solution {
    public int superEggDrop(int K, int N) {
            	int[] dp = new int[K+1];
    	Arrays.fill(dp, 1);
    	//步数
    	int step = 1;
    	//0个鸡蛋，无法使用
    	dp[0] = 0;
    	//鸡蛋可到达的最大楼层
    	while(dp[K] < N) {
    		for(int i = K; i>=1;i--)
    			dp[i] += dp[i-1]+1;
    		step++;
    	}
    	return step;
    }
}
