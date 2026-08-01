class RollingHash{
    long pow[]; 
    long base = 6767; 
    long hash[]; 
    long MOD = 1000000007L;

    RollingHash(String s ){
        int n = s.length(); 

        pow = new long[n+1]; 
        hash = new long[n+1]; 

        pow[0] = 1 ; 
        for(int i = 1 ; i <= n ; i++){
            pow[i] = (pow[i-1] * base) % MOD ; 
        }

        for(int i = 0 ; i < n ; i++){
            int x = s.charAt(i); 
            hash[i+1] = (hash[i] * base + x) % MOD; 
        }
    }

    long getHash(int l , int r){
        long ans = hash[r+1] - (hash[l] * pow[r-l+1]) % MOD; 
        if(ans < 0 ) ans+= MOD ; 
        return ans; 
    }
}
class Solution {
    RollingHash re;
    public  boolean check(int first , int second , String s){
        int n = s.length(); 

       


        int left = 0 ; 
        int len = Math.min(n-first , n-second);
        int right = len; 
        int ans = -1 ; 

        while(left <= right){
            int mid = left + (right - left) / 2; 

            if(re.getHash(first, first +mid-1) == re.getHash(second , second + mid -1)){
                left = mid+1; 
            }else{
                ans = mid; 
                right = mid-1; 
            }
        }
        if(ans == -1){
            if(len == n-second) return false;
            return true; 
        }
        else{
            if(s.charAt(first+ans-1) > s.charAt(second + ans -1)) return false; 
            return true;  
        }
        

    }
    public String lastSubstring(String s) {
        re = new RollingHash(s);
        // brute force 
        // TreeSet<String> set = new TreeSet<>(); 
        // int n = s.length(); 
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i ; j < n ; j++){
        //         set.add(s.substring(i , j+1));
        //     }
        // }
        // String ans = set.last();
        // return ans; 

        // // But got mle not even tle cause may be we cant store this much 
        // l le lee leet leetc leetco leetcod leetcode
        // e ee eet eetc eetco eetcod eetcode
        // e et etc etco etcod etcode 
        // t tc tco tcod tcode 
        // c co cod code 
        // o od ode
        // d de
        // e

        // a ab aba abab 
        // b ba bab 
        // a ab 
        // b
        


        // c ca cac caca cacac cacacb
        // a ac aca acac acab
        // c ca cac cacb
        // a ac acb
        // c cb 
        // b
        char prev = '<';
        int max = -1; 
        int n = s.length(); 
        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i); 
            if(ch > prev ){
                max = i; 
                prev = ch; 
            }
            else if(ch == prev ){
                //curr is greter it return false; 
                if(check(i , max , s)){
                    continue; 
                }
                else {
                    prev = ch ; 
                    max = i ; 
                }
            }
        }

        return s.substring(max , s.length()); 
    }
}