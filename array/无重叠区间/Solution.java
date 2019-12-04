/**
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
注意:
可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return 0;

        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);

        int bound = intervals[0][1], res = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < bound) res++;
            else bound = intervals[i][1];
        }

        return res;
    }
}
