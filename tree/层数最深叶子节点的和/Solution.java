/**
给你一棵二叉树，请你返回层数最深的叶子节点的和。
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
    int sum = 0;
    int max = -1;
    public int deepestLeavesSum(TreeNode root) {
        getMaxDepth(root, 0);
        return sum;

    }
   
    public void getMaxDepth(TreeNode root, int depth){
        if(root == null)
          return ;
        if(max < depth){
            max = depth;
            sum = root.val;
        }else if(max == depth){
            sum += root.val;
        }
        getMaxDepth(root.left, depth+1);
        getMaxDepth(root.right, depth+1);
    }

}
