/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的深拷贝。 
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        //保存节点信息
        Map<Node,Node> m=new HashMap<>();
        Node p=head;
        while(p !=null){
            Node t=new Node();
            t.val=p.val;
            m.put(p,t);
            p=p.next;
        }
        //从head开始复制
        p=head;
        while(p!=null){
            m.get(p).next=m.get(p.next);
            m.get(p).random=m.get(p.random);
            p=p.next;
        }
        return m.get(head);
    }
}
