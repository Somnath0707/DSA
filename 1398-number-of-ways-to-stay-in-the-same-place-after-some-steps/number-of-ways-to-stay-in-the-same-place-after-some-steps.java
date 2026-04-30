class Solution {
    int MOD = 1000000007;
    Map<String , Integer> map ; 
    public int f(int i , int currSteps , int steps , int len ){
        if(currSteps == steps && i == 1 ){
            return 1; 
        }
        else if(currSteps == steps && i != 1){
            return 0 ; 
        }
        String key = i + "#" + currSteps ; 

        if(map.containsKey(key)) return map.get(key);
        
        int left = 0 ; 
        int right = 0 ; 
        int stay = 0 ; 

        if(i-1 >= 1){
            left = f(i - 1 , currSteps + 1  , steps , len );
        }
        if(i +1 <= len ) {
            right = f(i + 1 , currSteps + 1 , steps , len );
        }

        stay = f(i , currSteps + 1 , steps , len ) ; 

        int ans = ((left + right ) % MOD + stay ) % MOD; 
        map.put(key , ans);
        return ans ;
    }
    public int numWays(int steps, int arrLen) {
        // Should we dp and do all the postion and when we traverse and are at then end if the i == 1 return + 1 else 0 ; 

        map = new HashMap<>();
        return f(1, 0 , steps , arrLen );
    }
}