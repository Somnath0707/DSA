class Solution {
    Map<String , Long> dp ;
    public long f(String s , int i , int tight , int leadZero ){
        int n = s.length ();
        String key = i + "," + tight + "," + leadZero;

        if(i >= n ){
            if(leadZero == 1){
                return 0 ;
            }
            return 1 ; 
        }
        if(dp.containsKey(key)) return dp.get(key);


        int limit = (tight == 1 ) ? s.charAt(i) -'0' : 9 ;
        long ans = 0 ; 

        for(int dig = 0  ; dig <= limit ; dig++){
            int nextTight = (tight == 1 && dig == limit) ? 1 : 0 ; 
            if(leadZero == 1 && dig == 0){
                ans += f(s , i + 1 , nextTight , 1 );
            }
            else{
                if(dig == 0 ) continue;
                ans += f(s , i+1 , nextTight , 0 );
            }
        }
        dp.put(key , ans );
        return ans;
    }
    public long countDistinct(long n) {
        
        String s = String.valueOf(n);
        dp = new HashMap<>();
        
        return f(s , 0 , 1 , 1 );
    }
}