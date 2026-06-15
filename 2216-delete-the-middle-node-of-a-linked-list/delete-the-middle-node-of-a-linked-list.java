/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head; 
        ListNode slow = head; 
        ListNode prev = null; 
        if(head.next == null ) return null ;
        while(fast != null && fast.next != null ){
            prev = slow ; 
            slow = slow.next ; 
            // if(fast.next.next == null ) break; 
            fast = fast.next.next; 
            // System.out.println(slow.val + " # " + fast.val + " # "  + prev.val);
            
        }

        prev.next = slow.next; 

        return head;
    }
}