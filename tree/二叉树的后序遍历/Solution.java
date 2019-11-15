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
    List<Integer> a=new ArrayList<>();
    //左->右->根
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null)
            return a;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        a.add(root.val);
        return a;
    }
}
