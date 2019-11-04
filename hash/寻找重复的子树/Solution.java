    /**
     * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
两棵树重复是指它们具有相同的结构以及相同的结点值。
     * @param root
     * @return
     */
class Solution {
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if (root == null) return res;
        saveRoute(root, res, map);
        return res;
    }

    //递归获取每个子树的路径，保存于Map中
    private String saveRoute(TreeNode node, List<TreeNode> res, HashMap<String, Integer> map) {
        if (node == null) return "";
        //自底向上获取每个节点的值
        String route = node.val + "," + saveRoute(node.left, res, map) + "," + saveRoute(node.right, res, map);
        //将结果放入map，判断是否有相同子树
        if (map.get(route) != null && map.get(route) == 1) {
            res.add(node);
        }
        map.put(route, map.getOrDefault(route, 0) + 1);
        return route;
    }
}
