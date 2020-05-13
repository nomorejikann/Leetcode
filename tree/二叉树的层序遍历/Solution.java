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
		 if(root==null)
	        {
	            return list;
	        }

	        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();  
	        queue.offer(root);  
	        while(!queue.isEmpty()) 
	        {
	            int num=queue.size();  
	            List<Integer> templist=new ArrayList<Integer>();   

	            while(num>0)
	            {
	                TreeNode node=queue.peek(); 
	                if(node.left!=null) 
	                {
	                    queue.offer(node.left); 
	                }
	                if(node.right!=null)   
	                {
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
