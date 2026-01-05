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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head,
                fast = head,
                slow = head; 

        // To reach the nth node 
        for(int i = 1; i < k ; i++){
            fast = fast.next;
        }   

        // So we have the refrence variabale on the nth node 
        first = fast ;

        // Loop run where fast start from Kth place so once it goes to last place slow will be in the Kth node from last 
        while (fast != null && fast.next != null){
            fast = fast.next; 
            slow = slow.next; 
            
        }

        // Swap them bad bois lmao 
        int temp = first.val;
        first.val = slow.val;
        slow.val = temp;

        return head; 


    }
}