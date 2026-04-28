class Solution {
    Long dp[] ; 
    public long f(int i , int [][] nums){
        if(i >= nums.length ) return 0 ; 
        if(dp[i] != null) return dp[i];
        long skip = f(i+1 , nums);

        long start = nums[i][0];
        int end = nums[i][1];
        long tip = nums[i][2];


        long profit = end - start + tip ; 

        int j = i+1 ; 
        while( j < nums.length && nums[j][0] < end){
            j++;
        }

        long take = profit + f(j , nums);


        return dp[i] = Math.max(take , skip);
    }
    public long maxTaxiEarnings(int n, int[][] rides) {
        // dp if the currStart < prevEnd i.e over lap then we can do two condition take or skip 
        // if not over lap we always take only 
        // we can sort and send it to the f() 
        // Nums , i , prev profit 
        // What would be the statees i fs , prevProfit of the confilicted pair still 
        // only one state i 

        Arrays.sort(rides , (a,b) -> {
            return a[0]-b[0];
        });
        dp = new Long[n+n];
        return f(0 , rides);

    }
}