/**
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l=new ArrayList<Integer>();
        for(ListNode node:lists){
            if(node==null)
                continue;
            l.add(node.val);
            
            while(node.next != null){
                node =node.next;
                l.add(node.val);
            }
        }
        Collections.sort(l);
        ListNode r=new ListNode(0);
        int len=l.size();
        if(len<1)
            return null;
        r.val=l.get(0);
        ListNode r1=r;
        for(int i=1;i<len;i++){
            ListNode t=new ListNode(l.get(i));
            r1.next=t;
            r1=r1.next;
        }
        return r;
    }
}
