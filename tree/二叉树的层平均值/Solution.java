/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Double> ans=new ArrayList<>();
        q.offer(root);
        int len=q.size();
        while(!q.isEmpty()){
            double sum=0.0;
            int size=len;
            while(len-->0){
                TreeNode n=q.poll();
                sum+=n.val;
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
            ans.add(sum/size);
            len=q.size();
        }
        return ans;
    }
}
