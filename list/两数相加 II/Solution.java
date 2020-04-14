/**
给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val==0)return l2;
        if(l2.val==0)return l1;
        ListNode r1=reverse(l1);
        ListNode r2=reverse(l2);
        int carry=0;
        ListNode pre=null;
        while(r1!=null||r2!=null){
            if(r1!=null){
                carry+=r1.val;
                r1=r1.next;
            }
            if(r2!=null){
                carry+=r2.val;
                r2=r2.next;

            }
            ListNode t=new ListNode(carry%10);
            carry/=10;
            t.next=pre;
            pre=t;
            }
        if(carry>0){
            ListNode t=new ListNode(carry);
            t.next=pre;
            pre=t;
        }
        
        return pre;
    }
    
    public ListNode reverse(ListNode root){
        ListNode pre=null;
        while(root!=null){
            ListNode n=root.next;
            root.next=pre;
            pre=root;
            root=n;
        }
        return pre;
    }
}
