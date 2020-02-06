/**
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
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

    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null)
          return head;
        if(head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
        }else{
            ListNode cur = head;
            while(cur.next != null && cur.val == cur.next.val)
              cur = cur.next;
            head = deleteDuplicates(cur.next);
        }
        return head;
    }

}
