class Solution {
    int dp[][]; 
    public int f(int i , int lane ,  int obs[] , int n ){
        if(i == n-1 ) return 0 ; 
        if(obs[i] == lane) return 1000000;
        if(dp[i][lane] != -1) return dp[i][lane]; 
        int ans = 0 ; 
        
        if(lane == obs[i+1] && obs[i+1] != 0  ){
            // System.out.println("Obstacle found at : "  + i);
            if(lane == 1 )
                ans = Math.min(1 + f(i , 2 , obs , n) , 1 + f(i, 3 , obs , n ));
            else if(lane == 2){
                ans = Math.min(1 + f(i , 1 , obs , n ) , 1 + f(i , 3 , obs , n ));
            }else if(lane == 3){
                ans = Math.min(1 + f(i , 1 , obs , n  ) , 1 + f(i , 2 , obs , n ));
            }
        }
        else {
            ans = f(i+1 , lane , obs , n);
        }
        return dp[i][lane] = ans;
    }
    public int minSideJumps(int[] obs) {
        // 3 lane road of len n that has n+1 point 

        // forg start at the point 0 in the second lane and want to jump to point n 

        //  we have obstacle of len n+1 where each obs[i] ranging (0 to 3) describes an obstacle on the lane obstacle[i] at point i if i == 0 no obs 

        // there would be atmost 1 obs in the 3 lanes at each point 
        
        // the forg can only travel form i to i + 1 on same lane if ther are no obs to avoid obs the from can also perform side jumps to another lane even if they are not adj cent at same poni if ther is no obs on the new lane 

        int n = obs.length;
        dp = new int[n][4];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , - 1);
        } 
        return f(0 , 2 ,  obs , n );
    }
}