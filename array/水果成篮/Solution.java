
class Solution {
    public int totalFruit(int[] tree) {
        int t = 0, ans = 0;
    	//计算每种的数量
    	Map<Integer, Integer> map = new HashMap<>();
    		
    	for(int i = 0; i < tree.length; i++) {
    		map.put(tree[i], map.getOrDefault(tree[i], 0)+1);
    		while(map.size() > 2) {
    	    	//已存在的水果
    			int l = map.get(tree[t]);
    			map.put(tree[t], l-1);
    			//一种水果移除完了,清空篮子
    			if(l-1==0)
    				map.remove(tree[t]);
    			//继续尝试移除下一个
    			t++;
    		}
    		//连续的最大数量
    		ans = Math.max(ans, i-t+1);
    	}
    	return ans;
    }
}
