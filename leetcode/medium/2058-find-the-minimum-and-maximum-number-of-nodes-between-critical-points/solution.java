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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr = head.next; 
        ListNode prev = head; 
        ListNode next = head.next.next; 
        if(next == null || curr == null) return new int[]{-1,-1};
        int ind = 1 ; 
        List<Integer> list = new ArrayList<>(); 
        while(next != null){
            if(curr.val > prev.val && curr.val > next.val){
                list.add(ind); 
            }else if(curr.val < next.val && curr.val < prev.val){
                list.add(ind); 
            }
            prev = curr; 
            curr = next; 
            next = next.next; 
            ind++;
        }
        if(list.size() < 2) return new int[]{-1,-1};
        int max = list.get(list.size()-1) - list.get(0);
        int min = Integer.MAX_VALUE; 

        for(int i = 1 ; i < list.size() ; i++){
            int temp = Math.abs(list.get(i)-list.get(i-1));
            min = Math.min(temp , min); 
        }

        return new int[]{min , max};
    }
}