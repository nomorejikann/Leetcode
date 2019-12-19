/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 */
class Solution {
    Integer pre=null;
    Integer min=0x7fffffff;
    //中序，从小到大排序
    public int minDiffInBST(TreeNode root) {
        if(root !=null){
            minDiffInBST(root.left);
            if(pre!=null)
                min=Math.min(min,root.val-pre);
            pre=root.val;
            minDiffInBST(root.right);
        }
            return min;
    }
}
