/**
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
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
    
    public int findSecondMinimumValue(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        value(root, l);
        int t = 0;
        if(l.size()< 2)
         return -1;
        int min = 0x7fffffff;
        for(int i = 1; i < l.size(); i++){
            min = Math.min(min, l.get(i));
        }
        return min;
    }

    public void value(TreeNode root, List set){
        if(root == null)
          return;
        if(!set.contains(root.val))
          set.add(root.val);
        value(root.left, set);
        value(root.right, set);

    }
    
}
