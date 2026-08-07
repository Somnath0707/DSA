class RollingHash{
    long base = 99999991L;

    long mod1 = 1000000007L;
    long mod2 = 1000000009L;

    long hash1[];
    long hash2[];

    long power1[];
    long power2[];

    RollingHash(String s ){
        int n = s.length();

        hash1 = new long[n+1];
        hash2 = new long[n+1];

        power1 = new long[n+1];
        power2 = new long[n+1];

        power1[0] = 1;
        power2[0] = 1;

        for(int i = 1 ; i <= n ; i++){
            power1[i] = (power1[i-1] * base) % mod1;
            power2[i] = (power2[i-1] * base) % mod2;

            hash1[i] = (hash1[i-1] * base + s.charAt(i-1)) % mod1;
            hash2[i] = (hash2[i-1] * base + s.charAt(i-1)) % mod2;
        }
    }

    public long[] getHash(int l , int r){

        long ans1 = hash1[r+1] - (hash1[l] * power1[r-l+1]) % mod1;
        if(ans1 < 0) ans1 += mod1;

        long ans2 = hash2[r+1] - (hash2[l] * power2[r-l+1]) % mod2;
        if(ans2 < 0) ans2 += mod2;

        return new long[]{ans1, ans2};
    }
}

class StreamChecker {

    Set<String> set;

    int min = 202;
    int max = 0;

    boolean valid[] = new boolean[202];

    StringBuilder str = new StringBuilder();

    public StreamChecker(String[] words) {

        StringBuilder str = new StringBuilder();

        set = new HashSet<>();

        for(String word : words){

            RollingHash re = new RollingHash(word);

            long[] hash = re.getHash(0 , word.length()-1);

            set.add(hash[0] + "#" + hash[1]);

            min = Math.min(word.length() , min);
            max = Math.max(word.length() , max);

            valid[word.length()] = true;
        }
    }

    public boolean query(char letter) {

        str.append(letter);

        if(str.length() < min) return false;

        if(str.length() > max){
            str.deleteCharAt(0);
        }

        RollingHash rh = new RollingHash(str.toString());

        // i can use rolling hash if i hash the streamcheck words and then i also also hash the current i pointre to left move ahed and j is to the last so each substring

        int n = str.length();

        for(int i = 0 ; i < n ; i++){

            int currentSuffixLength = n - i;

            if (!valid[currentSuffixLength]) continue;

            long[] check = rh.getHash(i , n-1);

            if(set.contains(check[0] + "#" + check[1])) return true;
        }

        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */