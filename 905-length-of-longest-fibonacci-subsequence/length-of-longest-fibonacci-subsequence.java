class Solution {
    Map<Integer,Integer> map;
    Integer dp[][]; 
    public int f(int i , int prev , int nums[]){
        if( i == nums.length) return 0 ; 
        int take =0 ; 
        if(dp[i][prev] != null ) return dp[i][prev]; 
        int nextVal = nums[i] + nums[prev]; 
        if(map.containsKey(nextVal)){
            int ind = map.get(nextVal);
            take = 1 + f(ind , i , nums);
        }
        return dp[i][prev] = take ; 

    }
    public int lenLongestFibSubseq(int[] arr) {
        map = new HashMap<>(); 
        int ind = 0 ; 
        for(int num : arr){
            map.put(num , ind++);
        }
        int ans = 0 ; 
        int n = arr.length;
        dp = new Integer[n][n]; 
        
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j< n ; j++){
                ans = Math.max(ans , 2 + f(j ,i  , arr));
            }
        }
        if( ans < 3 ) return 0; 
        return ans; 
    }
}