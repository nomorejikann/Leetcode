    /**
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     * @param points
     * @return
     */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
    	int count = 0;
        for(int[] i : points) {
        	//保存长度
            Map<Integer, Integer> m = new HashMap<>();
        	for(int[] j : points) {
        		if(i ==j)
        			continue;
        		//计算长度
        		int t = distant(i , j);
        		//计算组合总数,因为可以交换位置,所以*2
        		count += m.getOrDefault(t,0)*2;
        		//当前组合加1
        		m.put(t,m.getOrDefault(t,0) + 1);
        	}
        }
        return count;
    }
    //计算路径长度
    public int distant(int[] a, int[] b) {
    	return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}
