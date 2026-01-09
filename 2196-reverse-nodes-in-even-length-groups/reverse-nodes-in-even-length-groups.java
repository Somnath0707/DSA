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
    public ListNode reverseEvenLengthGroups(ListNode head) {

        // We will need a size = 1.2.3.4...
        // length of list 
        // while curr!= null
        //body : is groupSize = even then rewire i.e. reverse 
        // If odd then jump the whole off group
        // No need of dummy node as the head never changes


        int len = 0 ;
        int probGroupSize = 1;  // the group size that we are accepting not accounting for the len of the list 
        ListNode curr = head ;

        while(curr!= null){
            curr = curr.next;
            len++;
        }
        // length of list [Done]
        curr = head;
        ListNode p = null;


        // 9 nodes
        // 3 nodes remaining 
        // len 3 is the nodes remaining
        // but after the 3 we are expecting the next should be like 4 
        //i.e. probGroupSize = 4;
        while(curr != null){
            int actualGrpSize = Math.min(len, probGroupSize);
            


            // So this is even so reverse 
            if(actualGrpSize % 2 == 0 ){
                ListNode prev = null;
                int counter = 0 ; 
                ListNode temp1 = curr;


                // The actualGrpSize is also ensuring that we never go to null so no need to put the curr != null conditioin 
                while(counter < actualGrpSize){
                    counter++;
                    ListNode next = curr.next;
                    curr.next = prev ; 
                    prev = curr ; 
                    curr = next;
                }
                p.next = prev;
                temp1.next = curr; 
                p = temp1;
            }
            // Run till the end of the odd
            else{
                int counter = 0 ; 
                while(counter<actualGrpSize){
                    counter ++;
                    p = curr;
                    curr = curr.next;

                }
            }
            probGroupSize ++;
            len = len - actualGrpSize;

        }

        return head; 
        
    }
}