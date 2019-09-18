public class Solution {
  /**
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
              设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
              你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
              卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
    	if(prices.length < 1)
    		return 0;
    	//卖出，买入，冷冻期
        int sell =0, buy = -prices[0], cold = 0;
        for(int i : prices) {
        	//上一轮结果
        	int pre = buy;
        	//是否冷冻期后买入
        	buy = Math.max(buy, cold-i);
        	//冷冻期为上次交易结果
        	cold = sell;
        	
        	sell = Math.max(sell, pre+i);
        }
        return sell;
    }
}
