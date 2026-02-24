class Solution {
    public int f(int i , int j  , String s1 , String s2 ,int [][] dp){
        if(j<0) return i +1;
        if(i<0) return j + 1;
        

        // if the character is same 
        if(s1.charAt(i) == s2.charAt(j)){
            return f(i-1 , j-1 , s1 , s2 , dp);
        }

        if (dp[i][j] != -1 ) return dp[i][j];

        int insert = 1 + f(i , j-1 , s1 , s2 , dp ) ;
        int delete = 1 +  f(i-1 , j , s1 , s2 ,dp);
        int replace = 1 +  f(i - 1 , j-1 , s1 , s2 ,dp);

        return dp[i][j] = Math.min(insert , Math.min(delete , replace));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int [][] dp = new int [n][m];

        for(int i =0 ; i< n ; i++){
            Arrays.fill(dp[i] , -1);
        }

        return f(n -1 , m - 1 , word1 , word2 ,dp);
    }
}