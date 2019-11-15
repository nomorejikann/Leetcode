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
    List<Integer> a=new ArrayList<>();\
    //根->左->右
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null)
            return a;
          a.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return a;
    }
}
