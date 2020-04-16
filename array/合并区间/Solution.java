/**
给出一个区间的集合，请合并所有重叠的区间。
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

*/
class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        int[] starts=new int[n];
        int[] ends=new int[n];
        for(int i=0;i<n;i++){
            starts[i]=intervals[i][0];
            ends[i]=intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Integer[]> l = new ArrayList<>();
        
        for(int i=0,j=0;i<n;i++){
            if(i==n-1||starts[i+1]>ends[i]){
                l.add(new Integer[]{starts[j],ends[i]});
                j=i+1;
            }
        }
        int[][] res=new int[l.size()][2];
        for(int i = 0; i < l.size(); i++){
            res[i][0] = l.get(i)[0];
            res[i][1] = l.get(i)[1];
        }
        return res;

    }
}
