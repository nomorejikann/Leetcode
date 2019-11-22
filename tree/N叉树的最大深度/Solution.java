/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public int maxDepth(Node root) {
        if(root==null)
            return 0;
        int max=1;
        max=Math.max(max,depth(root,max));
        return max;
    }
    
    public int depth(Node root, int v){
        if(root==null)
          return v;
        int max=v;
        for(Node n:root.children)
            max=Math.max(max,depth(n,v+1));
        return max;
    }
}
