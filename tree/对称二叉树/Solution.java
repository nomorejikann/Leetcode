/**
给定一个二叉树，检查它是否是镜像对称的。
*/
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
    public boolean isSymmetric(TreeNode root) {
       if(root==null){
        	return true;
        }
        return is2Symmetric(root.left, root.right);
    }
   private boolean is2Symmetric(TreeNode root1,TreeNode root2){
    	if(root1==null && root2==null){
    		return true;
    	}
    	if(root1==null || root2==null || root1.val!=root2.val){
    		return false;
    	}
    	return is2Symmetric(root1.left, root2.right) && is2Symmetric(root1.right, root2.left);
    }

}
