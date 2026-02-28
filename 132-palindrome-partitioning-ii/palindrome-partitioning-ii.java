class Solution {
    public int f(String s , int i  , int dp[]){
        if(i == s.length()) return 0 ; 

        if(dp[i] != -1 ) return dp[i];
        StringBuilder temp = new StringBuilder();

        int min = Integer.MAX_VALUE;

        for(int j = i ; j < s.length() ; j++){
            if (isPalindrome(s, i, j)) {
                int count = 1 + f(s, j + 1, dp);
                min = Math.min(min, count);
            }
        }
        return dp [i] = min ; 

    }
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n];
        Arrays.fill(dp , -1);
        return f(s , 0 , dp ) - 1 ;
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