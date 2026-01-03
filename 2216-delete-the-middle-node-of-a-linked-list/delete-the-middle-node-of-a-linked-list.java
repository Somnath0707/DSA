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

        if(head.next == null){
            return null; 
        }
        ListNode fast = head; 
        ListNode slow = head; 
        ListNode temp = new ListNode(0);
                 temp.next = head;

        while (fast != null && fast.next != null){
            temp = temp.next ; 
            slow = slow.next ; 
            fast = fast.next.next; 
        }

        temp.next = slow.next ;
        return head;
        
    }
}