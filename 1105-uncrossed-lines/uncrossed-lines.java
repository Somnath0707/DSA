class Solution {
    public int f(int i , int prev , int [] nums1 , int [] nums2 , int dp[][]){
        if( prev >= nums2.length || i >= nums1.length) return 0 ;
        if(dp[i][prev] != -1 ) return dp[i][prev] ; 
        int take = 0; 
        for(int j = prev ; j < nums2.length; j++){
            if(nums1[i] == nums2[j]){
                take = Math.max(take , 1 + f(i+1 , j+1 , nums1 , nums2 , dp ));
            }
        }
        int skip = f(i+1 , prev , nums1 , nums2 , dp ) ; 

        return dp[i][prev] = Math.max(take , skip ) ; 
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int [][]dp = new int [nums1.length][nums2.length];
        for(int i = 0; i < nums1.length; i++){
            Arrays.fill(dp[i] , -1 ) ; 
        }
        return f(0 , 0 , nums1 , nums2 , dp);
    }
}