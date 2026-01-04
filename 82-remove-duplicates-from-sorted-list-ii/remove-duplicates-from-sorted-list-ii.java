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
    public ListNode deleteDuplicates(ListNode head) {
        //Make a current  pointer to check the current and next node & point it to head
        ListNode curr = head;  
        // Make a prev pointer later we will need 
        ListNode prev = null; 
        //here the constraints are from 0 to 300 no of node so edge case 
        if(head == null){
            return null;
        }

        // Now we can check logic 
        // Simple one so bs : 1. goo till the node where the curr.val and curr.next.val is equal
        //                    2. put the prev pointer just before the curr then skip the dups (so that value dont get lost (like zoro) )
        //                    3. When the dups are skipped place the we will have curr and a prev join em prev.next -> curr



        // We use curr!= null cause we have to go after the last node too that is to null 
        while(curr != null ){
            // Check the condition if curr.val == curr.next.val and also check for till the last element only 
            if(curr.next != null && curr.val == curr.next.val){
                
                int val = curr.val ; 

                //use the while loop to skip 
                while(curr!= null && curr.val == val ){
                    curr = curr.next; 
                }
                // After we have skipped we put the prev.next to curr
                if(prev != null){
                    prev.next = curr; 
                }
                // If the prev is null we know its the head of the node cause we will change the prev right after the curr goes next to head

                //   1->2->3->4->5
                //   c              prev is null here
                //    1->2->3->4->5
                //    p  c
                //    1->2->3->4->5
                //       p  c

                //as you can see the only place where the prev is null is head 
                else{
                    head = curr ; 
                }
            }
            // After that if the curr and curr.next are not equal just upadte the rest 
            else{
                prev = curr ; 
                curr = curr.next; 
            }


        }
        return head; 
    }
}