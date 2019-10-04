    /**
     * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。
     任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
输入列表已经按左 x 坐标 Li  进行升序排列。
输出列表必须按 x 位排序。
输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
     * @param buildings
     * @return
     */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> build = new ArrayList<>();
        for(int[] bs : buildings) {
        	//添加(x1,y) 即左边缘
        	build.add(new int[] {bs[0],-bs[2]});
        	//添加(x2,y) 即右边缘
        	build.add(new int[] {bs[1],bs[2]});
        }
        //根据x顺序排序
        Collections.sort(build, new Comparator<int[]>() {
        	public int compare(int[] a, int[] b) {
        		
        		if(a[0] != b[0])
        			return a[0] - b[0];
        		
        		else
        			return a[1] - b[1];
        	}
		});
        //最大堆
        Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
        });
        int pre = 0;
        //x轴交点
        maxHeap.offer(0);
        for(int[] bs : build) {
        	
        	//x1 左边缘进入
        	if(bs[1]<0)
        		maxHeap.offer(-bs[1]);
        	//x2 右边缘移出
        	else
        		maxHeap.remove(bs[1]);
        	//低于当前最高且左边缘大于最高的左边缘的会被遮挡
        	int max = maxHeap.peek();
        	//不在同一高度，即不会被遮挡
        	if(max != pre) {
        		List<Integer> l = new ArrayList<>();
        		l.add(bs[0]);
        		l.add(max);
        		ans.add(l);
        		pre = max;
        	}
        }
        
        return ans;
    }
}
