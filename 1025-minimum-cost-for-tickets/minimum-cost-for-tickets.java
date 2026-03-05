class Solution {
    public int f(int i , int [] days , int[]cost, int[] dp){
        int n = days.length; 
        if( i >= days.length) return 0 ; 

        if(dp[i] != -1 ) return dp[i] ; 

        // for the 1 day 
        int cost_day = cost[0] + f(i + 1, days , cost , dp);

        int si ;
        for(si = i ; si < n && days[si] < days[i] + 7 ; si ++);
        int cost_week = cost[1] + f(si , days , cost , dp );

        for(si = i ; si < n && days[si] < days[i] + 30 ; si ++) ;
        int cost_Month = cost[2] + f(si , days , cost ,dp  ) ; 

        return dp[i] =  Math.min(cost_day, Math.min(cost_week , cost_Month));
        

       
    }
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int [days.length];
        Arrays.fill(dp , -1 ) ;
        return f(0 ,days , costs , dp );
    }
}