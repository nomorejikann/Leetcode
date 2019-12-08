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
    public int minDepth(TreeNode root) {
        if(root == null)
          return 0;
       if(root.left == null && root.right == null)
         return 1;
       int min = Integer.MAX_VALUE;
       if(root.left != null)
         min = Math.min(minDepth(root.left), min);
       if(root.right != null)
         min = Math.min(minDepth(root.right), min);
        return min +1;
    }
}
