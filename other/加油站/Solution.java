    /**
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * @param gas
     * @param cost
     * @return
     */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //油箱剩余的油
    	int tank = 0;
        //所经过的总和
        int sum = 0;
        //可以到达的第一个起点
        int ret = 0;
        for(int i = 0; i < gas.length; i++) {
        	tank += gas[i]-cost[i];
        	if(tank < 0) {
        		sum += tank;
        		tank = 0;
        		ret = i+1;
        	}
        }
        if(sum + tank >= 0)
        	return ret;
        return -1;
    }
}
