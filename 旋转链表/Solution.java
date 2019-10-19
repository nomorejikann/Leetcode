/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 	/**
	 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
	 * @param head
	 * @param k
	 * @return
	 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null)
        	return head;
    	int len = 1;
    	ListNode temp = head;
        while(temp.next != null) {
        	temp = temp.next;
        	len++;
        }
        k = len - (k % len);
        if(k == len)
        	return head;
        //创建一个环
        temp.next = head;
        ListNode pre = null;
        ListNode node = head;
        while(k > 0) {
        	//环前的节点
        	if(k == 1)
        		pre = node;
        	node = node.next;
        	k--;
        }
        //截断环
        pre.next = null;
        return node;
    }
}
