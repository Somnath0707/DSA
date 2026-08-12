class Solution {
    Boolean dp[][] ; 
    public boolean f(int i , int balance , String s){
        if(balance < 0) return false; 
        int n = s.length() ; 
        if(i == n ) return balance == 0 ; 

        char ch = s.charAt(i); 
        boolean ans = false ; 
        if(dp[i][balance] != null) return dp[i][balance]; 
        if(ch == '('){
            ans = ans || f(i+1 , balance+1 , s); 
        }
        else if(ch == ')'){
            ans = ans || f(i+1 , balance-1 , s);
        }
        else{
            ans = ans || f(i+1 , balance +1 , s); 
            ans = ans || f(i+1 , balance -1 , s); 
            ans = ans || f(i+1 , balance , s);
        }

        return dp[i][balance] = ans; 
    }
    public boolean checkValidString(String s) {
        int n = s.length(); 
        dp = new Boolean[n][n];
        return f(0 , 0 , s); 
    }
}