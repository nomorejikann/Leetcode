    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
例如，给定三角形：
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * @param triangle
     * @return
     */
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
       if(envelopes.length < 1)
    		return 0;
    	//依据宽度和高度排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        //最长子序列
        for(int i = 1; i < envelopes.length; i++) {

        	for(int j = 0; j < i; j++)
        		if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
        		  dp[i] = Math.max(dp[i], dp[j]+1);
        }
        int max = 1;
        for(int i : dp)
        	max = Math.max(max, i);
        return max;
    }
}
