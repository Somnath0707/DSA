class RollingHash{
    long base = 31 ; 
    long MOD = 1000000007;
    long pow[]; 
    long hash[]; 

    RollingHash(String s){
        int n = s.length(); 
        pow = new long[n+1]; 
        hash = new long[n]; 


        pow[0] = 1 ; 
        for(int i = 1 ; i <= n ; i++){
            pow[i] = (pow[i-1]*base) % MOD; 
        }


        hash[0] = s.charAt(0) - 'a' + 1 ; 

        for(int i = 1 ; i < n ; i++){
            hash[i] = (hash[i-1] * base + (s.charAt(i) - 'a' + 1)) % MOD;
        }
    }

    long getHash(int left  , int right){
        if(left == 0) return hash[right]; 

        long ans = (hash[right] - hash[left-1] * pow[right - left + 1]) % MOD;
        if(ans < 0 ) ans += MOD; 

        return ans; 
    }
}

class Solution {
    public String longestPrefix(String s) {
        RollingHash rh = new RollingHash(s); 
        int maxLeft = -1 ; 
        int maxRight = -1 ; 
        int maxLen = -1; 
        int n = s.length(); 
        for(int i = 0 ; i < n-1 ; i++){
            int left = 0; 
            int right = i ; 

            int newLeft = n-right-1; 
            int newRight = n-1; 

            if(rh.getHash(left , right) == rh.getHash(newLeft , newRight)){
                int currMax = right - left + 1; 
                if(currMax > maxLen){
                    maxLeft = left; 
                    maxRight = right; 
                }
            }
        }

        if(maxLeft == -1 || maxRight == -1 ) return ""; 
        return s.substring(maxLeft , maxRight+1);
    }
}