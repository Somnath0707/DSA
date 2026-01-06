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
    public ListNode oddEvenList(ListNode head) {

        if(head == null){
            return null;
        }
        // Start at the head of List as its no 1 and that is odd 
        ListNode odd = head ;
        // Start at the head.next that is 2 no which is even 
        ListNode even = head.next; 

        // We need to connect the last of odd to evenfirst so keep this as Head of even nodes
        ListNode evenHead = even;


        // Run this loop till the even goes out of the list 
        while(even != null && even.next != null){

            // So we know the odd are 1, 3, 4 so we know its odd.next.next 
            odd.next = odd.next.next; 
            odd = odd.next; 


            // We know for the even 2, 4, 6 so we know to do same 
            even.next = even.next.next;
            even = even.next ;
        }
        // After this the odd will be to the last element of odd 
        // even will be out of park that is null 

        // The list will look like 
        // 1->3->5   2->4->6
        //       o   eH         connect the odd (0) to the evenHead(eH)
        odd.next = evenHead;

        // Return Normal head
        return head; 
    }
}