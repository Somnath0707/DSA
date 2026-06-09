class Solution {
    int MOD = 1000000007;
    Map<String , Integer> dp ; 
    public int f(int i , int count , int end , int k){
        if(count == k){
            if(i == end ) return 1 ; 
            return 0 ; 
        }
        String key = i + "#" + count; 
        if(dp.containsKey(key)) return dp.get(key);

        int takeOne = 0 ; 
        int giveOne = 0 ; 

        takeOne =( takeOne + f(i+1 , count+1 , end , k )) % MOD;
        giveOne = (giveOne + f(i-1 , count+ 1 , end , k )) % MOD;

        int ans  = (takeOne + giveOne) % MOD;

        dp.put(key , ans ); 
        return ans; 
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        // we are given two number start and end 

        // we are intitally at the starting on a infinte numbr line 

        // with one step you can move either one pos to left or to right 

        // given pos interget k return the no of diff way to reach end startin from start pos such that you can performexctly k steps 

        // the number line have -ve nos to oo
        // two ways are considered diff if the order of the step is not exactly the same 
        // Its look like dp problem butt I think i have done something like this previously 
        // as here we can go front and go back +1 and -1 might give me infinte 
        // or maybe it is possible to use dp as there is a limit of k steps 

        // so we can do +1 -1 for k step if the steps increase > k we can back track lmao   

        dp = new HashMap<>();

        // but I still think bfs is there 
        return f(startPos , 0 , endPos , k);
    }
}