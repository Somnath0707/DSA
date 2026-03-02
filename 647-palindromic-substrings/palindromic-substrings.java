class Solution {
    int ans = 0; 
    public int f(int i , String s ) {
        if(i == s.length()) return 0 ; 

        int count = 0; 
        for(int j = i ; j < s.length() ; j++){
            if(isPalindrome( i , j , s )){
                count ++;
            }
        }

        ans += count ;
        f(i+1 , s ) ; 
        return ans;
    }
    public int countSubstrings(String s) {
        return f(0 , s ) ; 
    }

     public boolean isPalindrome( int l , int r , String s ){
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}