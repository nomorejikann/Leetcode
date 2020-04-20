/**
给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。
*/
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
		if (grid.length == 0) {
			return 0;
		}
		char[][] visit = new char[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (visit[i][j] != '1') {
					if (grid[i][j] == '1') {
						count++;
					}
				}
				dfsvisit(grid, visit, i, j);
			}

		}
		return count;
    }
    
    public void dfsvisit(char[][] grid, char[][] visit, int i, int j) {
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1) {
			return;
		} else if (grid[i][j] == '0') {
			return;
		} else if (visit[i][j] == '1') {
			return;
		} else {
			visit[i][j] = '1';
			dfsvisit(grid, visit, i + 1, j);
			dfsvisit(grid, visit, i - 1, j);
			dfsvisit(grid, visit, i, j + 1);
			dfsvisit(grid, visit, i, j - 1);
		}
	}
}
