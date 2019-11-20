/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 	    /**
	     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
	     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
	     * @param root
	     * @return
	     */
class Solution {
       public boolean isBalanced(TreeNode root) {
            if(root == null)
	        	return true;
	    	int l = depth(root.left, 0);
	        int r = depth(root.right, 0);
	        if(l < 0 || r < 0)
	        	return false;
	        return Math.abs(l - r) <= 1;
	    }
	    
	    public int depth(TreeNode root, int v) {
	    	if(root == null)
	    		return v;
	    	int l = depth(root.left, v+1);
	    	int r = depth(root.right, v+1);
	    	int p = l > r ? l : r;
	    	//本身是否大于1
	    	p = Math.abs(l-r) > 1 ? -1 : p;
	    	return p;
	    }
}
