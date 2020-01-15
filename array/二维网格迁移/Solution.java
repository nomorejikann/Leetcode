/**
给你一个 n 行 m 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

每次「迁移」操作将会引发下述活动：

位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
位于 grid[m - 1][ - 1] 的元素将会移动到 grid[0][0]。
请你返回 k 次迁移操作后最终得到的 二维网格。
*/
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] nums = new int[grid.length * grid[0].length];
        for(int i = 0, iMax = grid.length;i < iMax;i++) {
            for(int j = 0, jMax = grid[0].length;j < jMax;j++) {
                k %= nums.length;
                nums[k++] = grid[i][j];
            }
        }
        k = 0;
        List<List<Integer>> lists = new ArrayList<>(grid.length);
        for(int i = 0, iMax = grid.length;i < iMax;i++) {
            List<Integer> tempList = new ArrayList<>(grid[0].length);
            for(int j = 0, jMax = grid[0].length;j < jMax;j++) {
                tempList.add(nums[k++]);
            }
            lists.add(tempList);
        }
        return lists;
    }
}
