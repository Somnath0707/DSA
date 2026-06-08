class Solution {
    Integer dp[][] ; 
    public int f(int i , int j , int score ,  int nums[]){

        if( j - i + 1 < 2) return 0 ; 
        

        if(dp[i][j] != null) return dp[i][j]; 
       // if i is last element then we know that i will be i-2 and j-2 or 0 and 1 of 1 and n-1
       // what should be the base case if the list size is < 2 we cant answer 

       //if i + j is not same score we cant answer 
       // or we do like put i and score if i is at first place check for like i + (i+1) and i + n-1 
       // if i = n-1 then we cheeck like n-1 + n-2 or 0 + n-1 and take the max among them but what is the base case here 
    //    if the socre is not same or the size < 2 we cant answer 
        int ans = 0 ; 
        int n = nums.length ; 

    // if is first elemetn 
    if(nums[i] + nums[i+1] == score){
        ans = Math.max(ans , 1 + f(i+2 , j , score , nums));
    }

    if(nums[i] + nums[j] == score){
        ans = Math.max(ans , 1 + f(i+1 , j-1 , score , nums));
    }

    if(nums[j] + nums[j-1] == score ) {
        ans = Math.max(ans , 1 + f(i, j-2 , score , nums));
    }


    return dp[i][j] = ans; 

        
    }
    public int maxOperations(int[] nums) {
        // we can perfrom any operations on nums which has atleast 2 elements 

        // choose the first two element of nus and delete them 
        // chose last two and delete them 
        // choose first and last element of nums anddelete them 

        // The score of the ope is the sum of the delete elements 

        // task : maximize the numb of operation that can be perfromed such that all the operation ahve same score 

        // obious giveway that this is dp 
        // we have chooices 
        // we have 20000 len only 

        // 3 states i , j , sum 
        int ans = 0; 
        int n = nums.length ; 

        // assume the first 
        // we take first two and give them as range 0 and n-1 where they can do i+1 or n-1 and n-2
        dp = new Integer[n][n];
        ans = Math.max(ans , 1 + f(2 , n-1 , nums[0] + nums[1] , nums) );

        dp= new Integer[n][n] ; 
        ans = Math.max(ans , 1 + f(1 , n-2 , nums[0] + nums[n-1] , nums));
        dp = new Integer[n][n] ; 
        ans = Math.max(ans , 1 + f(0 , n-3 , nums[n-1] + nums[n-2] , nums));


        return ans; 
    }
}