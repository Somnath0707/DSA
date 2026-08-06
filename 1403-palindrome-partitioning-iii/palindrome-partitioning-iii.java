class Solution {
    Integer dp[][]; 
    public int check(String s){
        int left = 0; 
        int right = s.length()-1;
        int ans = 0 ; 
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) ans++; 
            left++; 
            right--;
        }
        return ans; 
    }
    public int f(int i , int total , String s , int k){
        if(i == s.length()){
            if(total == k ){
                return 0 ; 
            }
            return 1000000;
        }
        if(dp[i][total] != null) return dp[i][total]; 

        if(total > k ) return 1000000; 

        long take = Integer.MAX_VALUE ; 
        for(int ind = i ; ind < s.length() ; ind++){

            int add  = check(s.substring(i , ind+1));
            take = Math.min(take , add + f(ind+1 , total+1 , s , k));

        }

        return dp[i][total] = (int)take; 
    }
    public int palindromePartition(String s, int k) {
        if(k == s.length() ) return 0 ; 
        dp = new Integer[s.length()][100];
        return f(0 , 0 , s ,k);

    }
}