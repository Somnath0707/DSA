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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head; 
        int len = 0; 
        while(curr != null){
            curr = curr.next;
            len ++;
        }
        curr = head;
        int uniformDistanceNumber = len / k;
        int reminder = len % k ;

        ListNode[] res = new ListNode[k];

        curr = head; 

        for(int i = 0; i < k ; i ++){
            int count = uniformDistanceNumber;
            if(reminder > 0){
                count = count + 1; 
                reminder --;
            }
            // count + if reminder is greater than 0 add 1 else 0;

            // Create a Linked List of these nodes 
            ListNode temp1 = curr; 
            int counter = 0 ; 
            ListNode prev = null; 
            while(counter < count ){
                prev = curr;
                curr = curr.next;
                counter = counter + 1 ; 
            }
            if(prev != null){
                prev.next = null; 
            } 
            res[i] = temp1; 
        }
        return res;
    }
}