class Solution {
   String dp[][]; 
    public String check(String str , String str2){
        if(str.equals("Invalid") ) return str2; 
        if(str2.equals("Invalid")) return str; 
        if(str.length() > str2.length()){
            return str;
        }else if(str.length() < str2.length()) return str2; 
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) > str2.charAt(i)){
                return str; 
            }
            else if(str.charAt(i) < str2.charAt(i)){
                return str2; 
            }
        } 

        return str; 
    }
    public String f(int i , int cost,  int target , int nums[]){
        int n = nums.length; 
        if(cost == target) return ""; 
        if(i == n+1){
            return "Invalid"; 
        }

        if(!dp[i][cost].equals("-1")) return dp[i][cost]; 

        String take = "Invalid";
        String skip = "Invalid";

        if(cost+nums[i-1] <= target){
            String takeSame = f(1 , cost + nums[i-1] , target , nums);
            if(!takeSame.equals("Invalid")) 
            take = i + takeSame; 
        }

        skip = f(i+1 , cost , target , nums);

        String ans =  check(take , skip); 

        dp[i][cost] = ans ; 
        return ans; 
    }
    public String largestNumber(int[] nums, int target) {
        // we are give an array of cost and integer target 
        //  we have to return the maximum integer we can paint under following rules:
        // 1. The cost of painting a digit (i+1) is given by cost[i]
        // 2.The total cost used must be equal to target
        // 3. The integer does not have 0 digits
        dp = new String[10][5001];
        for(int i = 0 ; i < 10 ; i++){
            Arrays.fill(dp[i] , "-1");
        }
        String ans =  f(1 , 0 , target , nums);
        if(ans.equals("Invalid")) return "0" ; 
        return ans; 
    }
}