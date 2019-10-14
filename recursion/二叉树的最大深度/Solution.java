/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*给定一个二叉树，找出其最大深度。
*
*二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
*
*说明: 叶子节点是指没有子节点的节点。
*/
class Solution {
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int lcount = 1;
        int rcount = 1;
		TreeNode left = root.left;
		TreeNode right = root.right;
		if(left != null) {
			
			lcount += maxDepth(left);
		}
        if(right != null) {
			
			rcount += maxDepth(right);
		}
		return lcount>=rcount?lcount:rcount; 
    }
}
