class Solution {
    int dp[][][]; 
    public int f(int i  , int op1 , int op2 , int k , int nums[]){
        if(i == nums.length) return 0 ; 

        int ans = Integer.MAX_VALUE ; 
        if(dp[i][op1][op2] != -1 ) return dp[i][op1][op2]; 

        if(op1 > 0 && op2 >0){
            double num = nums[i]; 
            int temp = (int)Math.ceil(nums[i]/2.0); 
            if(nums[i]-k >= 0 ){
                int take = Integer.MAX_VALUE;
                int taken = (int)Math.ceil((nums[i]-k) /2.0);
                if(temp - k >= 0){
                    take  = Math.min(temp - k + f(i+1 , op1-1 , op2-1 , k , nums ) , taken + f(i+1 , op1-1 , op2-1 , k , nums));
                }
                else take = taken + f(i+1 , op1 -1 , op2 -1 , k , nums);
                ans = Math.min(nums[i] + f(i + 1, op1, op2, k, nums),
                        Math.min(nums[i] - k + f(i + 1, op1, op2 - 1, k, nums),
                            Math.min(temp + f(i + 1, op1 - 1, op2, k, nums),
                                    take)));
            }

            else 
            ans = Math.min(nums[i] + f(i+1 , op1 , op2 , k , nums) , temp + f(i+1 , op1-1 , op2 , k , nums));
        }
        else if(op1 > 0){
            double num = nums[i]; 
            int temp = (int)Math.ceil(nums[i] / 2.0); 
            ans = Math.min(nums[i] + f(i+1 , op1 , op2 , k , nums) , temp+ f(i+1 , op1-1 , op2 , k , nums));
        }
        else if(op2 > 0){
            if(nums[i] - k >=0 ){
                 ans = Math.min(nums[i] + f(i+1 , op1 , op2 , k , nums) , nums[i]-k + f(i+1 , op1 , op2-1 , k , nums));
            }
            else {
                ans = nums[i] + f(i+1 , op1 , op2 , k,nums);
            }
        }
        else {
            ans = nums[i] + f(i+1 , op1 , op2 ,k ,  nums);
        }

        return dp[i][op1][op2] = ans; 
    }
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        // its dp 
        // at each point try doing all like trying doing operation 1 or operation 2 or no operation and to the answer add the number and try to get the min number the state could be the i , op op2 which would go on changing 
        int n= nums.length; 
        dp = new int [n][op1+1][op2+1]; 
        for(int i =0 ; i < n ; i++){
            for(int j = 0 ; j <= op1 ; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }
        return f(0 , op1 , op2 , k , nums);
    }
}