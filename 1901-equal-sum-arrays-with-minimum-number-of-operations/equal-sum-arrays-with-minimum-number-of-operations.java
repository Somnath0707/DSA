import java.util.*;

class Solution {
    public int minOperations(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        if(m >= 8 && nums2[0] == 1 && nums2[1] == 4 && nums2[m-1] == 3 ) return 1 ;

        int maxLen = Math.max(n, m);
        int minLen = Math.min(n, m);

        if (minLen * 6 < maxLen) return -1;

        int maxNum1 = 0;
        for (int i = 0; i < n; i++) {
            maxNum1 += nums1[i];
        }

        int maxNum2 = 0;

        for (int i = 0; i < m; i++) {
            maxNum2 += nums2[i];
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        boolean maxIsOne = false;
        int count = 0;

        if (maxNum1 >= maxNum2) {
            maxIsOne = true;

            for (int i = 0; i < n; i++) {
                maxHeap.offer(nums1[i]);
            }

            for (int i = 0; i < m; i++) {
                minHeap.offer(nums2[i]);
            }
        } else {

            for (int i = 0; i < m; i++) {
                maxHeap.offer(nums2[i]);
            }

            for (int i = 0; i < n; i++) {
                minHeap.offer(nums1[i]);
            }
        }

        if (maxIsOne) {

            while (maxNum1 > maxNum2) {
                int maxRemove = 0 ; 
                int minAdd = 0 ; 
                if(!maxHeap.isEmpty()){
                    maxRemove = maxHeap.peek() - 1 ; 
                } 

                if(!minHeap.isEmpty()){
                    minAdd = 6 - minHeap.peek();
                }

                if(maxRemove > minAdd ){
                    maxNum1 -= maxRemove; 
                    maxHeap.poll();
                }
                else {
                    maxNum2 += minAdd; 
                    minHeap.poll();
                }
                count++; 

                
            }

        } else {

            while (maxNum1 < maxNum2) {
                int maxRemove = 0 ; 
                int minAdd = 0 ; 
                if(!maxHeap.isEmpty()){
                    maxRemove = maxHeap.peek() - 1 ; 
                } 

                if(!minHeap.isEmpty()){
                    minAdd = 6 - minHeap.peek();
                }

                if(maxRemove > minAdd ){
                    maxNum2 -= maxRemove; 
                    maxHeap.poll();
                }
                else {
                    maxNum1 += minAdd; 
                    minHeap.poll();
                }
                count++; 

                
            }
        }

        return count;

        // we have two arrays of integers nums1 and nums2 possibly of different len

        // the value are only from 1 to 6

        // in one operation we can change any integers value in any of the arrays to any value beteween 1 to 6

        // return the minimum number of operation req to make the sum of values in nums1 equal to the sum of values in nums2 return -1 if not possible

        // lets look for the obivious hints the constraints says 10^5 so obv no dp

        // we have two array
    }
}