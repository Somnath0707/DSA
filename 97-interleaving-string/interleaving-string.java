class Solution {
    public boolean f(int i , int j , int k , String s1, String s2, String s3 , Boolean dp[][]){
        if(k == s3.length()) return true; 

        if(dp[i][j] != null) return dp[i][j] ; 
        boolean ans = false; 

        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
            ans = ans || f(i+1 , j , k +1 , s1 , s2 , s3 , dp);
        }

        if(j < s2.length() && s2.charAt(j) == s3 .charAt(k)){
            ans = ans || f(i , j+1 , k+1 , s1 , s2 , s3 , dp );
        }

        return dp[i][j] = ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean dp[][] = new Boolean [s1.length() + 1][s2.length() + 1];
        if (s1.length() + s2.length() != s3.length()) return false;
        return f(0 , 0 , 0 , s1 , s2 , s3 , dp );
    }
}