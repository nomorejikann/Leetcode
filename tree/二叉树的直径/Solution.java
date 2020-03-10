/**
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0; 
        int L = depth(node.left); 
        int R = depth(node.right);
        ans = Math.max(ans, L+R); 
        return Math.max(L, R) + 1;
    }
}
