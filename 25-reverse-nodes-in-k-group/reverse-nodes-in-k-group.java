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
    public ListNode reverseKGroup(ListNode head, int k) {

        // How many times we should reverse 
        //         reverse... k nodes
        // linking 

        int len = 0 ; 
        ListNode curr = head;

        while(curr != null){
            curr = curr.next ; 
            len ++; 
        }
        curr = head;
        // 20 and k = 6
        // 6...6...6...2 


        int times = len / k ; 


        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy;
        
        for(int i = 0 ; i < times ; i++){
            // reverse k nodes
            int count = 0 ; 

            ListNode p2 = curr; 
            ListNode prev = null;
            while(count < k && curr != null){
                count++;

                // Save the next 
                ListNode next = curr.next;

                // reverse the connection 
                curr.next = prev ; 
                
                // Update the prev to curr
                prev = curr ; 

                // Move the curr forward
                curr = next;
            }


            p1.next = prev;
            p2.next = curr; 

            p1 = p2;
        }
        return dummy.next; 
    }
}