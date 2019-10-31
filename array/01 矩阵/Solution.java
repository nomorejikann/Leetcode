    /**
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
两个相邻元素间的距离为 1 。
     * @param matrix
     * @return
     */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //源点
        Queue<int[]> queue = new LinkedList<>();
    	
    	for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		//0作为源点开始扩散
        		if(matrix[i][j] == 0)
        			queue.offer(new int[] {i, j});
        		//非0则需要计算扩散距离
        		else
        			matrix[i][j] = 0x7fffffff;
        	}
        }
    	//方向
    	int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    	//计算
    	while(!queue.isEmpty()) {
    		//起点
    		int[] pose = queue.poll();
    		for(int[] d : dir) {
    			int x = pose[0] + d[0];
    			int y = pose[1] + d[1];
    			//范围判断
    			if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length
    					//比较当前与之前的扩散距离
    					|| matrix[x][y]<=matrix[pose[0]][pose[1]]+1)
    				continue;
    			matrix[x][y] = matrix[pose[0]][pose[1]]+1;
    			//添加当前为起点
    			queue.offer(new int[] {x, y});
    		}
    	}
    	return matrix;
    }
}
