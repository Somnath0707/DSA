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
    public void reorderList(ListNode head) {
        ListNode fast = head; 
        ListNode slow = head;


        while (fast != null && fast.next != null){
            slow = slow.next ; 
            fast = fast.next.next; 
        }


        ListNode prev = null ,
                 curr = slow ; 

        while (curr!= null){
            ListNode next = curr.next; 
            curr.next = prev ;
            prev = curr; 
            curr = next;
        }

        // 1->2->3->->\/
        //.         5->4

        ListNode l1 = head,
                 l2 = prev;

        while (l2.next != null){
            ListNode l1Next = l1.next;
            l1.next = l2;


            ListNode l2Next = l2.next ;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next; 
        }

    }
}