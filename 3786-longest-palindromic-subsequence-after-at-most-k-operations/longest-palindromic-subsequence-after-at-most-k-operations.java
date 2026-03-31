class Solution {

    int dp[][][] ;
    public int f(int i , int j , int k_remain , String s  ){

        if(i > j ) {
            return 0 ; 
        }
        if(i == j ) return 1 ; 


        if(dp[i][j][k_remain] != -1 ) return dp[i][j][k_remain];
        int takeDirect = 0 ; 
        int takeWithK = 0 ; 
        int skip = 0 ; 
        if(s.charAt(i) == s.charAt(j)){
            takeDirect = 2 + f(i +1 , j -1 , k_remain , s);
        }  
        int diff = Math.abs(s.charAt(i) - s.charAt(j));
        int cost = Math.min (diff , 26 - diff);


        if( cost <= k_remain){
            takeWithK =  2 + f(i + 1 , j -1 , k_remain-cost , s);
        }

        skip = Math.max(f(i+1 , j , k_remain , s) , f(i , j - 1 , k_remain , s ) );

        return dp[i][j][k_remain] = Math.max(takeDirect ,Math.max( takeWithK , skip)) ; 

    }
    public int longestPalindromicSubsequence(String s, int k) {
        dp = new int[s.length() ][s.length()][k+1];
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = 0 ; j < s.length() ; j ++){
                Arrays.fill(dp[i][j] , - 1 ) ; 
            }
        }
        return f(0 , s.length()-1 , k , s );
    }
}

// abced -> a c c d 
// if the abs diff betwen i and j is 1 && k >0 we can convert it to the number right 
// now the question remains is for the a and z 
// how do we make the abs dis of  a and z as 1 
//so the logic is start form the first and last element i and j compare if we can make them palindrome or maybe same if yesh we move both else we move once i and once j just the longest palindrome subsequence

