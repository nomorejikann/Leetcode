/**
 * 二叉树的序列化与反序列化
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 */
public class Codec {

	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null)
            return "null";
        //层序遍历
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        sb.append(root.val).append(",");
        while(!queue.isEmpty()){
            TreeNode t=queue.poll();
            
            TreeNode left=t.left;
            TreeNode right=t.right;
            if(left!=null){
                queue.offer(left);
                sb.append(left.val).append(",");
            }else{
                sb.append("null,");
            }
            if(right!=null){
                queue.offer(right);
                sb.append(right.val).append(",");
            }else{
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs=data.split(",");
        if(strs[0].equals("null"))
            return null;
        //层序遍历复原
        Queue<TreeNode> queue=new LinkedList<>();
        int depth=0;
        TreeNode root=new TreeNode(Integer.valueOf(strs[depth++]));
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode t=queue.poll();
            int leftIdx=depth++;
            int rightIdx=depth++;
            if(!"null".equals(strs[leftIdx])){
                TreeNode left=new TreeNode(Integer.valueOf(strs[leftIdx]));
                t.left=left;
                queue.add(left);
            }
            if(!"null".equals(strs[rightIdx])){
                TreeNode right=new TreeNode(Integer.valueOf(strs[rightIdx]));
                t.right=right;
                queue.add(right);
            }
        }
        return root;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
    	 val = x; 
     }
}
