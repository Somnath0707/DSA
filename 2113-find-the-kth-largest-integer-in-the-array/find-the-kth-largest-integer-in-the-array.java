
import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();

        for(int i = 0 ; i < nums.length ; i++){
            BigInteger num = new BigInteger(nums[i]);

            if(pq.size() == k){
                pq.offer(num);
                pq.poll();
                continue;
            }

            pq.offer(num);
        }

        String ans = String.valueOf(pq.peek());

        return ans;
    }
}