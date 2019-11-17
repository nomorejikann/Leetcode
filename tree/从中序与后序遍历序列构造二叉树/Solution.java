/**
	  * 根据一棵树的中序遍历与后序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
中序遍历 inorder = [9,3,15,20,7] 左->根->右
后序遍历 postorder = [9,15,7,20,3]  左->右->根
	  * @param inorder
	  * @param postorder
	  * @return
	  */
class Solution{
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		 return build(postorder, inorder, postorder.length - 1, 0, inorder.length);
	 }
   public TreeNode build(int[] post, int[] in, int postEnd, int inStart, int len) {
	        if(len == 0) {
	            return null;
	        }
	        //根/父节点
	        int p = post[postEnd];
	        TreeNode root = new TreeNode(p);
	        if(len == 1) {
	            return root;
	        }
	        for(int i = len - 1; i >= 0; --i) {
	        	//找到根/父节点
	            if(in[inStart + i] == p) {
	            	  //划分左子树
	                root.left = build(post, in, postEnd - (len - i), inStart, i);
	                //划分右子树
	                root.right = build(post, in, postEnd - 1, inStart + i + 1, len - i - 1);
	                return root;
	            }
	        }
	        return null;
	    }
}
