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
	    /**
	     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
一般来说，删除节点可分为两个步骤：
首先找到需要删除的节点；
如果找到了，删除它。
	     * @param root
	     * @param key
	     * @return
	     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
	    		return root;
	        if(root.val > key) {
	        	root.left = deleteNode(root.left, key);
	        }else if(root.val < key) {
	        	root.right = deleteNode(root.right, key);
	        }else {
	        	if(root.left != null && root.right != null) {
	        		TreeNode n = root.right;
	        		while(n.left != null)
	        			n = n.left;
	        		root.val = n.val;
	        		//删除右节点的最左节点
	        		root.right = deleteNode(root.right, root.val);
	        	}else {
	        		//删除右节点
	        		if(root.left != null)
	        			root = root.left;
	        		//删除左节点,或本身
	        		else
	        			root = root.right;
	        	}
	        }
	        return root;
    }
}
