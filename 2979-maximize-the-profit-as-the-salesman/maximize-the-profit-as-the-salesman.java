class Solution {
    int m ; 
    Integer dp[]; 
    public int bs(int left , int right , int find, List<List<Integer>> offers){
        right--; 
        int ans = -1 ;
        while(left <= right){
            int mid = left+(right-left)/2; 
            if(offers.get(mid).get(0) > find){
                ans = mid; 
                right = mid-1; 
            }
            else{
                left = mid+1; 
            }
        }
        return ans; 
    }
    public int f(int i , int n  , List<List<Integer>> offers){
        if(i >= m) return 0 ; 

        if(dp[i] != null) return dp[i]; 
        int skip = 0 ; 
        int start = offers.get(i).get(0);
        int end = offers.get(i).get(1); 
        int gold = offers.get(i).get(2); 
        int take = gold;
        int ind = bs(i , m , end , offers); 
        if(ind != -1){
            take  += f(ind , n , offers);
        }
        skip = f(i+1 , n , offers) ; 

        return dp[i] =  Math.max(take , skip ) ; 



    }
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        // see which gives me max gold per sale or per page 

        // we can use like dp + binary search how sort by the start 
        // at each point if we take find the next in the offer that is > the end after once we get that index we can take that or not take that 

        // so like take if we take now and end is 0 find the next which is 1 or more so 1 here we can take 1 or not take one that is i+1 after the binary search we can take any cause but if we decide to take we do same binary search 

        m = offers.size(); 
        Collections.sort(offers , (a,b)-> Integer.compare(a.get(0) , b.get(0)));
        dp = new Integer[m]; 
        return f(0 , n , offers);
    }
}