class Solution {
  /**
	  * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
	  * @param root
	  * @param p
	  * @param q
	  * @return
	  */
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return root;
		//p为左(父)节点，q为右节点,左节点必定小于右节点
		if(p.val > q.val) {
			TreeNode temp = p;
			p = q;
			q = temp;
		}
		
		TreeNode node = root;
		while(node != null) {
			//当前节点小于左节点
			if(node.val < p.val)
				//向右面查找
				node = node.right;
			//当前节点大于右节点
			else if(node.val > q.val)
				//向左面查找
				node = node.left;
			else
				return node;
		}
		//未找到
		return null;
	  }
}
