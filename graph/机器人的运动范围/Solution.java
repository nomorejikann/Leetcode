/**
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
*/
class Solution {
    public int movingCount(int m, int n, int k) {
        if(k == 0) return 1;
        int res = 1;
        int[][] dir = new int[][] {{1, 0}, {0, 1}};
        boolean[][] visit = new boolean[m][n];        
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{0,0});
        visit[0][0] = true;

        while (!queue.isEmpty()) {
           Integer[] p = queue.poll();
            for (int i = 0; i < 2; i++) {
                int nextX = p[0] + dir[i][0];
                int nextY = p[1] + dir[i][1];
                if (nextX >= m || nextY >= n || visit[nextX][nextY] || getNumericalDigit(nextX) + getNumericalDigit(nextY) > k) 
continue;
                
                    queue.offer(new Integer[]{nextX, nextY});
                    visit[nextX][nextY] = true;
                    res++;
            }
        }

        return res;
    }



    private int getNumericalDigit(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}


