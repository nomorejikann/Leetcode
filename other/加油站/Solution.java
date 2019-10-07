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
