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
    public ListNode rotateRight(ListNode head, int k) {


        int check = 0; 
        ListNode temp = head; 
        ListNode newHead = null;
        int len = 0 ; 
        // Get the list size();

        while(temp != null){
            temp = temp.next;
            len++;
        }
        temp = head;
        if(len == 1) return head; 
        if(len == 0 ) return null;
        k = k % len;
        if(k == 0 ) return head; 

        while(true){
            if(temp.next == null){
                temp.next = head;
                head = newHead;
                break;
            }
            check++;
            if(len - check == k){
                newHead = temp.next;
                temp.next = null;
                temp = newHead;
                continue;
            }
            temp = temp.next;
            
        }
        return head; 
    }   
}