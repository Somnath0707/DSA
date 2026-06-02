class Solution {

    Integer dp[][][]; 
    public int f(int i , int j , int taken ,  int nums1[] , int nums2[]){
        if(i == nums1.length || j == nums2.length){
            if(taken ==1 ) return 0 ; 
            return (int) -1e9;
        }
        if(dp[i][j][taken] != null) return dp[i][j][taken]; 

        int take = Math.max(nums1[i] * nums2[j] + f(i+1 , j + 1 , 1 , nums1 , nums2 ) , Math.max(f(i+1 , j , taken , nums1 , nums2) , f(i , j+1 , taken , nums1 , nums2)));

        return dp[i][j][taken] = take;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length ; 
        int m = nums2.length;
        dp = new Integer [n][m][2]; 
        
        return f(0 , 0 , 0 , nums1 , nums2);
    }
}