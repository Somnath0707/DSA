class Solution {
    Long dp[][][]; 
    public long f(int i , int j , int newK , int nums1[] , int nums2[] , int k){
        int n = nums1.length ; 
        int m = nums2.length ; 
        if(newK == k){
            return 0 ; 
        }
        if(i == n|| j == m ){
            if(newK == k){
                return 0 ; 
            }
            return Long.MIN_VALUE; 
        }

        if(dp[i][j][newK] != null) return dp[i][j][newK]; 
        // for incrementing i 
        // int latestK = k+1; 
        long take = Long.MIN_VALUE ; 
        long skip1 = Long.MIN_VALUE; 
        long skip2 = Long.MIN_VALUE; 
        long next = f(i+1 , j+1 , newK+1 , nums1 , nums2 , k);
        if(next != Long.MIN_VALUE)
        take = Math.max(take , 1L * nums1[i] * nums2[j] + next);

        skip1 = f(i+1 , j , newK , nums1 , nums2 , k); 
        skip2 = f(i , j+1 , newK , nums1 , nums2 , k);

        take = Math.max(take , Math.max(skip1 , skip2));


        return dp[i][j][newK] = take; 
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // 
        int n = nums1.length ; 
        int m = nums2.length ; 

        dp = new Long[n+1][m+1][k+1];
        return f(0 , 0 , 0 , nums1 , nums2 , k) ; 
    }
}