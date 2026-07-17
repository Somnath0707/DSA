class Solution {
    Boolean dp[][] ; 
    public boolean  f(int l , int r ,String s , boolean[][] isPal){
        if(l > r)return false; 
        int n = s.length(); 

        if(dp[l][r] != null) return dp[l][r]; 

        boolean take = false; 
        if(isPal[0][l-1] && isPal[l][r] && isPal[r+1][n-1]){
            return dp[l][r] = true; 
        }

        take = f(l+1 , r , s , isPal)  || f(l , r-1 , s,isPal) || f(l+1 , r-1 , s,isPal); 

        return dp[l][r] = take; 
    }
    public boolean checkPartitioning(String s) {
       
        int n = s.length();
         dp = new Boolean[n][n]; 

         boolean[][] isPal = new boolean[n][n];
        
        // Build the table: lengths 1 to n
        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    // A string is a palindrome if its outer chars match 
                    // AND its inner string is a palindrome (or it's length 1 or 2)
                    if (length <= 2) {
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i + 1][j - 1];
                    }
                }
            }
        }
        return f(1 , n-2 , s , isPal);


    }
    public boolean isPalindrome(String s , int l , int r ){
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
// /"abcbdd"