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
     private List<Integer> answerList = new ArrayList<Integer>();
	  //左->根->右
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
			return answerList;
		}
			
		
		inorderTraversal(root.left);
		answerList.add(root.val);
		inorderTraversal(root.right);
		return answerList;
    }
}
