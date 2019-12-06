/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> l=new ArrayList<>();
        if(root==null)
            return l;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int size=q.size();
        while(!q.isEmpty()){
        TreeNode n=null;
            while(size-->0){
                n=q.poll();
                if(n.left!=null)
                q.offer(n.left);
                if(n.right!=null)
                q.offer(n.right);
            }
                size=q.size();
                if(n!=null)
                    l.add(n.val);

        }
        return l;
    }
}
