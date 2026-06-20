class Solution {
    public static boolean isPower(int y, int base) {
        if (y <= 0 || base <= 1) return false;
        if (y == 1) return true; // 
        
        while (y % base == 0) {
            y /= base;
        }
        return y == 1;
    }
    public int f(int i , String s ){
        if(i == s.length()) return 0 ; 

        int ans = Integer.MAX_VALUE ; 
        if(s.charAt(i) == '0' ) return Integer.MAX_VALUE ; 
        for(int j = i ; j < s.length() ; j++){
            int num = Integer.parseInt(s.substring(i , j+1) , 2);

            if(isPower(num , 5)){
                int next = f(j+1, s);
                if(next != Integer.MAX_VALUE)
                    ans = Math.min(ans, 1 + next);
            }
        }

        return ans; 
    }
    public int minimumBeautifulSubstrings(String s) {
        // we take the and if we match the power of 5 then we add +1 to the answer and if the next there is no valid partation we backtrack 

        // this is backtracking question for sure 

        int ans = f(0 , s);
        if(ans >= Integer.MAX_VALUE ) return -1 ; 
        return ans ; 
    }
}