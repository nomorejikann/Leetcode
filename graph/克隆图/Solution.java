/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
	/**
	 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
节点数介于 1 到 100 之间。
无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
必须将给定节点的拷贝作为对克隆图的引用返回。
	 * @param node
	 * @return
	 */
class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
        	return null;
        Node root = map.get(node.val);
        //记忆化
        if(root != null)
        	return root;
        root = new Node(node.val, new ArrayList<>());
        map.put(root.val, root);
        //dfs
        for(Node n : node.neighbors) 
        	root.neighbors.add(cloneGraph(n));
        
        return root;
    }
}
