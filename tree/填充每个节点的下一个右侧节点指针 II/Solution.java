	    /**
	     * 给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有 next 指针都被设置为 NULL。
	     * @param root
	     * @return
	     */
class Solution{
  public Node connect(Node root) {
          if(root ==null)
                return null;
            Queue<Node> que=new LinkedList<>();
            que.offer(root);
            while(!que.isEmpty()){
              //每层
                int size=que.size();
                while(size-->0){
                    Node n=que.poll();
                    //每层尾部
                    if(size==0)
                        n.next=null;
                    else
                        n.next=que.peek();
                    if(n.left!=null)
                        que.offer(n.left);
                    if(n.right!=null)
                        que.offer(n.right);
                }

            }
            return root;
        }
}
