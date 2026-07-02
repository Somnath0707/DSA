class Solution {
    int dp[][][]; 
    public int f(int i , int parity , int sumParity , int [] nums){
        if(i == nums.length) return 0 ; 

        int take = 0 ; 
        int skip = 0 ; 
        int currParity = nums[i] % 2;

        if(dp[i][parity][sumParity] != -1 ) return dp[i][parity][sumParity]; 

        if(parity == 3){
            take = 1 + f(i+1 , currParity , sumParity , nums); 
        }
        else if(sumParity == 3){
            int temp = 0 ; 
            if(parity != currParity){
                temp = 1; 
            }
            take = 1 + f(i+1 , currParity , temp , nums);
        }
        else if(sumParity == 1  ){
            if(parity == 1 && currParity == 0 || currParity == 1 && parity == 0 ){
                take = 1 + f(i+1 , currParity , sumParity , nums);
            }
        }
        else if(sumParity == 0 ){
            if(parity == 1 && currParity == 1 || parity == 0 && currParity == 0){
                take = 1 + f(i+1 , currParity , sumParity , nums);
            }
        }

        skip = f(i+1 , parity , sumParity , nums);

        return  dp[i][parity][sumParity] =  Math.max(take , skip); 
    }
    public int maximumLength(int[] nums) {
        int ans = 0 ; 
        int n = nums.length ; 
        dp = new int[n][4][4];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<= 3 ; j++){
                Arrays.fill(dp[i][j] , -1 );
            }
        } 
        return f(0 , 3 , 3 , nums); 
    }
}