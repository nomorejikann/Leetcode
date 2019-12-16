/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 计算给定二叉树的所有左叶子之和。
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
          return 0;
        return sum(root.left,true)+sum(root.right,false);
    }

    public int sum(TreeNode t, boolean f){
        if(t == null)
        return 0;
        if(f && t.left == null && t.right == null)
          return t.val;
          int l = 0;
          int r = 0;
        if(t.left != null)
          l= sum(t.left, true);
        if(t.right != null)
          r = sum(t.right,false);
        return l+r;
    }
}
