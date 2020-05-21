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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,0,inorder.length-1);
    }
    
    public TreeNode build(int[] pre, int[] in,int preL,int inL,int inR){
        
        if(inL>inR){
            return null;
        }
        TreeNode root=new TreeNode(pre[preL]);
        int k=0;
        for(int i=inL;i<=inR;++i){
            if(in[i]==pre[preL]){
                k=i;
                break;
            }
        }
        
        int numLeft=k-inL;
        
        root.left=build(pre,in,preL+1,inL,k-1);
        root.right=build(pre,in,preL+numLeft+1,k+1,inR);
        return root;
        
    }
}
