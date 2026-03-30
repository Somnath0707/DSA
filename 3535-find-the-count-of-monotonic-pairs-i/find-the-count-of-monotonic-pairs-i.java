class Solution {
    int dp[][][]; 
    int MOD = 1000000007;
    public int f(int i , int prev , int  prev2 , int[] nums){
        if(i == nums.length ) return 1 ; 


        if(dp[i][prev][prev2] != -1 ) return dp[i][prev][prev2];

        int num = nums[i];
        int count = 0 ; 

        for(int indx = 0 ; indx <= num ; indx++){
            int left = indx ; 
            int right = num - indx ; 

            if(left <= prev && right >= prev2){
                count = (count + f(i +1 , left , right , nums)) % MOD;
            }
            else{
                break;
            }
        }
        return dp[i][prev][prev2] = count ; 
        
    }
    public int countOfPairs(int[] nums) {
        dp = new int[nums.length][51][51];
        for(int i = 0 ; i< nums.length ; i++){
            for(int j = 0 ; j < 51 ; j++){
                Arrays.fill(dp[i][j] , - 1 ); 
            }
        }
        int ans =  f(0 , 50 , 0 , nums);
        return ans ;
    }
}


// Input: nums = [2,3,2]
// 1 2  1 1
// 0 2   1 1
// 2   0  
// 0   2