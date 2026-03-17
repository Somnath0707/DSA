class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0 ; 
        for(int i =0; i < reward1.length ; i++){
            sum+= reward2[i];
        }

        int n = reward1.length;
        for(int i = 0 ; i< n ; i++){
            pq.offer(reward1[i] - reward2[i]);
        }

        int ans = sum;

        for(int i =0 ; i< k ; i++){
            int temp = pq.poll();
            ans+= temp;
        }
        return ans; 
    }
}