class Solution {
    Boolean dp[][]; 
    public boolean  f(int i , int sum ,  int target , String str ){
        if(i == str.length()){
            if( sum == target ) return true; 
            return false; 
        }
        if (sum > target) return false;

        if(dp[i][sum] != null) return dp[i][sum]; 
        boolean take = false; 

        for(int ind = i ; ind < str.length() ; ind++){
            int add = Integer.parseInt(str.substring(i , ind+1));
            if(f(ind+1 , sum+add , target , str)) return dp[i][sum] = true; 
        }

        return dp[i][sum] =  false; 
    }
    boolean check(int val , int i ){
       String str = String.valueOf(val); 
       int target = i ; 
        dp = new Boolean[8][1001]; 
       return f(0 ,0, target , str); 
    }
    public int punishmentNumber(int n) {
        // Map<Integer,Integer> map =  new HashMap<>(); 
        int ans = 0; 
        for(int i = 1 ; i <= n ; i++){
           boolean val = check(i*i , i); 
           if(val)
           ans+= i*i; 
        }
        

        return ans; 

    }
}