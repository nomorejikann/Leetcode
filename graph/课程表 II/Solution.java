/**
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph=new ArrayList[numCourses];
        int[] depth=new int[numCourses];
        int[] ans=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            if(graph[prerequisites[i][1]]==null)
                graph[prerequisites[i][1]]=new ArrayList<Integer>();
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            depth[prerequisites[i][0]]++;
        }
        int c=0;
        for(int i=0;i<numCourses;i++){
            for(int j=0;j<numCourses;j++){
                
                if(depth[j]==0){
                    
                    ans[c++]=j;
                    List<Integer> l=graph[j];
                    depth[j]=-1;
                    if(null!=l){
                        for(int k:l)
                            depth[k]--;
                    }
                }
            }
        }
        if(c!=numCourses)
            return new int[]{};
        return ans;
    }
}
