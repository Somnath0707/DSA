class Solution {
    // Map<String , Boolean > dp ; 
    public boolean f(int i , int j , int sum1 , int sum2 , int who , int [] nums){
        if(i > j){
            if(sum1 >=sum2)return true; 
            return false; 
        }
        // String key = i + "#" + j + "#" + sum1 + "#" + sum2 + "#" + who ; 
        // if(dp.containsKey(key)) return dp.get(key); 
        boolean  take = false; 
        if(who == 0 ){
            int newSum1 = sum1 + nums[i];
            int newSum2 = sum1 + nums[j]; 
            take = take || f(i+1 , j , newSum1 , sum2 , 1 , nums); 
            take = take || f(i , j-1 , newSum2 , sum2 , 1 , nums); 
        }
        else{
            int newSum = sum2 + nums[i]; 
            int newSum1 = sum2 + nums[j]; 
            // if any case the second make it false answer will be false
            take = f(i+1 , j ,  sum1 , newSum , 0 , nums) && f(i , j-1 , sum1 , newSum1 , 0 , nums);
        }
        // dp.put(key , take);
        return take;  
    }
    public boolean predictTheWinner(int[] nums) {
        // so we can do is like take 
        // so if i == j and sum1 > sum2 return true; return false 
        int n = nums.length; 
        // dp = new HashMap<>(); 
        return f(0 , n-1 , 0 , 0 , 0 , nums); 
    }
}