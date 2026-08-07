class RollingHash{
    long base = 99999991L  ; 
    long mod = 1000000007L ; 

    long hash[] ; 
    long power[]; 

    RollingHash(String s ){
        int n = s.length();
        power = new long[n+1]; 
        hash = new long[n+1]; 
        power[0] = 1; 

        for(int i = 1 ; i < n+1 ; i++){
            power[i] = (power[i-1]*base ) % mod; 
            hash[i] = (hash[i-1]*base + s.charAt(i-1)) % mod; 
        }
    }

    public long getHash(int l , int r){
        long ans = hash[r+1]-(hash[l] * power[r-l+1]) % mod ; 

        if( ans < 0) ans+= mod; 
        return ans; 
    }

}
class StreamChecker {
    Set<Long> set ;
    int min = 202 ; 
    int max = 0 ; 
    boolean valid[] = new boolean [202]; 
    StringBuilder str = new StringBuilder(); 
    public StreamChecker(String[] words) {
        StringBuilder str = new StringBuilder();
        set = new HashSet<>(); 
        
        for( String word : words){
            RollingHash re = new RollingHash(word);
            long hash = re.getHash(0 , word.length()-1);
            set.add(hash);
            min = Math.min(word.length() , min);
            max = Math.max(word.length() , max); 
            valid[word.length()] = true; 
        }
    }
    
    public boolean query(char letter) {
        str.append(letter); 
        if(str.length() < min) return false; 
        if (str.length() > max) {
            str.deleteCharAt(0);
        }
        RollingHash rh = new RollingHash(str.toString());
        
        // i can use rolling hash if i hash the streamcheck words and then i also also hash the current i pointre to left move ahed and j is to the last so each substring 
        int n = str.length(); 
        for(int i = 0 ; i < n ; i++){
            int currentSuffixLength = n - i;
            if (!valid[currentSuffixLength]) continue;
            long check = rh.getHash(i , n-1);
            
            if(set.contains(check)) return true; 
        }
        return false; 
        
    }
}
    

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */