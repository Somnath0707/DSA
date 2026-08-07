class Solution {
    int MOD = 1000000007;
    public int sumOfGoodSubsequences(int[] nums) {
        // this is not the normal dp on subsequence why cause the dp on sub seq already is 0(n^2) and here we would also need to carry sum of that sub sequence so the state would be i , sum which is not feasible for the constraint of the 10^5 

        // there was a question where i didnt solve which involed like find all the sub sequce which were ending at that index this seems to be from that family 

        // like find the sum of the subsequence ending at index i where subsequence condtion is diff == 1 

        // one state is i , diff     and put in the 
        int n = nums.length; 
        long count[] = new long[100005]; 
        long sum[] = new long[100005]; 

        for(int i = 0 ; i < n ; i++){
            int val = nums[i]; 
            count[val+1] = (count[val+1] +  (1L * 1 + 1L * count[val-1+1] + 1L *  count[val+1+1])) % MOD ;
            sum[val+1] = (sum[val+1] + 1L * val + 1L * sum[val-1+1] + 1L * sum[val+1+1] + 1L * val * count[val-1+1] + 1L* val * count[val+1+1] ) % MOD;
        }

        int total = 0 ; 
        for(int i = 0 ; i < sum.length ; i++){
            total = (int)(total + sum[i]) % MOD; 
        }

        return total;
    }
}