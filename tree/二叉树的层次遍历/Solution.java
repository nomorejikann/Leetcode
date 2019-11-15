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
   
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> list = new LinkedList<>();
		  if(root==null){
	        return list;
	    }
      //FIFO
	    LinkedList<TreeNode> queue=new LinkedList<TreeNode>();  
	    //每层
      queue.offer(root);  
	    //
      while(!queue.isEmpty()) {
	        //当前层的所有元素
          int num=queue.size();  
	        List<Integer> templist=new ArrayList<Integer>();   
	        //每层的元素
          while(num>0){
	            TreeNode node=queue.peek(); 
	            if(node.left!=null) {
	                //下一层
                  queue.offer(node.left); 
	            }
	            if(node.right!=null) {
	                //下一层
                  queue.offer(node.right);  
	            }
	            int data=queue.poll().val;  
	            templist.add(data); 
	                num--; 
	            }
	            list.add(templist);
	        }

	        return list;
    }
}
