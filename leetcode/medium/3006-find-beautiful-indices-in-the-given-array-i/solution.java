class RollingHash {
    long MOD = 1_000_000_007L;
    long BASE = 911382323L;

    long[] hash;
    long[] power;

    RollingHash(String s) {
        int n = s.length();

        hash = new long[n + 1];
        power = new long[n + 1];

        power[0] = 1;

        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] * BASE + s.charAt(i)) % MOD;
            power[i + 1] = (power[i] * BASE) % MOD;
        }
    }

    // hash of s[l ... r-1]
    long getHash(int l, int r) {
        return (hash[r] - hash[l] * power[r - l] % MOD + MOD) % MOD;
    }
}
class Solution {

    public boolean check(int val , List<Integer> list , int k){
        int left = 0 ; 
        int right = list.size()-1; 
        while(left <= right){
            int mid = left + (right-left)/2;
            int diff = Math.abs(val-list.get(mid));
            if(diff <= k){
                return true; 
            }
            
            if(list.get(mid)<val){
                left = mid+1; 
            }
            else{
                right = mid-1; 
            }
            
        }
        return false; 
    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        RollingHash sh = new RollingHash(a); 
        RollingHash rh = new RollingHash(b); 
        RollingHash real = new RollingHash(s); 

        List<Integer> list = new ArrayList<>(); 
        List<Integer> listB = new ArrayList<>(); 
        int n = s.length(); 
        int lenA = a.length(); 

        for(int i = 0 ; i <= n-lenA ; i++){
            if(real.getHash(i ,i+lenA ) == sh.getHash(0 , lenA)){
                list.add(i); 
            }
        }

        int lenB = b.length(); 
        for(int i = 0 ; i <= n - lenB ; i++){
            if(real.getHash(i,i+lenB) == rh.getHash(0 , lenB)){
                listB.add(i); 
            }
        }
        List<Integer> res = new ArrayList<>(); 
        for(int i = 0 ; i < list.size(); i++){
            int val = list.get(i); 
            if(check(val , listB , k ))res.add(val); 
        }
        
        return res ;
    }
}