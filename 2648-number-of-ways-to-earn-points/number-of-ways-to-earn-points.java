class Solution {
    Integer dp[][][];
    int MOD = 1000000007;
    public int f(int i , int currSum , int attempt , int target , int types[][]){
        int n = types.length;
        // base case 
        if(currSum == target){
            // System.out.println(" Index : "  + i + " output " + currSum);''
            // currSum = 0 ; 
            return 1;
        } 
        if(i == n) return 0; 

        if(dp[i][currSum][attempt] != null) return dp[i][currSum][attempt];

        int take = 0 ; 
        int skip = 0 ; 

        // we can only take when the sum dont excced the target or we have question to attempt 
        if(currSum + types[i][1] <= target && attempt < types[i][0]){
            
            
            // System.out.println(i + " curr is  " + currSum);
            take = f(i , currSum + types[i][1], attempt+1 , target , types);
        }

        // System.out.println("Before skip the curr is : " + currSum);
        // we skip currQue so attemp becomes 0 
        skip = f(i+1 , currSum , 0 , target , types );



        return dp[i][currSum][attempt] = (take + skip) % MOD;
    }
    public int waysToReachTarget(int target, int[][] types) {
        //we hve target and types a 2d array 
        // types is [count][marks ] the coutn is number of question and mark is marks per question 
        // return number of way we an earn target point 

        // same of same type are indistinguishable

        // ex if there are 3 ques of the same type then solving 1 and 2nd is same as solving 1 and 3rd que or the 2nd and 3rd que 
        int n = types.length;
        // if i dont solve this i am gay frrrrrr
        dp = new Integer[n][target+1][51];
        
        return f(0 , 0 , 0 , target , types);

    }
}