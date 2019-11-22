/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        //层级元素
        int size=q.size();
        while(!q.isEmpty()){
            List<Integer> l=new ArrayList<>();
            while(size-->0){
                Node n=q.poll();
                l.add(n.val);
                for(Node t:n.children)
                    q.offer(t);
            }
            ans.add(l);
            size=q.size();
        }
        return ans;
    }
}
