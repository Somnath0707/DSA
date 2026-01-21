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
    public ListNode mergeKLists(ListNode[] lists) {

        List<Integer> store = new ArrayList<>();

        for(int i = 0 ; i < lists.length ; i++){
            // Here the lists is the linked list array so we need cant directly put them into the list 
            ListNode temp = lists[i];

            while(temp != null){
                store.add(temp.val);
                temp = temp.next;
            }
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int s : store){
            minHeap.offer(s);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(!minHeap.isEmpty()){
            curr.next = new ListNode(minHeap.poll());
            curr = curr.next;
        }
        return dummy.next;
    }
}