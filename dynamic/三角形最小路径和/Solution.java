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
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        //初始化最后一行
        for(int i = 0; i < triangle.size(); i++)
        	dp[i] = triangle.get(triangle.size()-1).get(i);
    
        //自底向上
        for(int i = triangle.size()-2; i>=0; i--) {
        	for(int j = 0; j < triangle.get(i).size(); j++) 
        		//自左向右加上上一层
        		dp[j] = Math.min(dp[j]+triangle.get(i).get(j), dp[j+1]+triangle.get(i).get(j));
        	
        }
        
        return dp[0];
    }
}
