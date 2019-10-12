/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 	/**
	 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
给定 1->2->3->4, 你应该返回 2->1->4->3.
	 * @param head
	 * @return
	 */
class Solution {
    public ListNode swapPairs(ListNode head) {
       if(head == null || head.next == null)
        	return head;
        //2
        ListNode n = head.next;
        //1-->3
        head.next = swapPairs(n.next);
        //2-->1
        n.next = head;
        return n;
    }
}
