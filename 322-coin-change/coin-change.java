class Solution {
    Map<String , Integer> map ; 
    public int f(int i , int total, int coins[] , int amount){
        if(total == amount) return 0 ; 
        String key = i + "#" + total ;
        if(i == coins.length) return (int)1e9 ; 
        if(map.containsKey(key)) return map.get(key);
        
        int take = (int) 1e9 ; 
        if(coins[i]+ total <= amount){
            take = 1 + f(i , total + coins[i] , coins ,amount);
        }
        int notTake = f(i+1 , total , coins , amount);

        int ans =  Math.min(take , notTake);
        map.put(key , ans );
        return ans ;
    }
    public int coinChange(int[] coins, int amount) {
        map = new HashMap<>();
        int ans =  f(0 , 0 , coins , amount);
        if( ans == 1e9)return -1 ; 
        return ans;
    }
}