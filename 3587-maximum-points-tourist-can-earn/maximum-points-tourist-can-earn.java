class Solution {
    int n ; 
    int k ; 

    int dp[][]; 
    // here i is the curr j is the des , day is the day
    public int f(int i , int day , int [][] nums , int [][]arr){
        if(day > k-1) return 0 ; 
        if(i >= n ) return 0 ;

        if(dp[i][day] != -1 ) return dp[i][day];

        // at each point we can either stay at one pont 

        int point = 0 ; 

        int stay = 0 ; 
        int travel = 0 ; 

        stay = nums[day][i] + f(i ,  day+1 , nums ,arr);
        int max = 0 ; 
        int dest = 0 ; 
        for(int ind = 0 ; ind < n ; ind++){
            // if same location 
            if(ind == i) continue;
            travel = Math.max(travel , arr[i][ind] + f(ind , day+1 , nums , arr));
        }

        


        return dp[i][day] = Math.max(stay , travel);

        
    }
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        // Two int are given ok n and k 
        // tow arr stayScore and travelScor 
        // n : cites number each city directly connected to other city 
        // K : 0 indexed days 
        // They can choose any city as start 

        // two chooice 
        //1 : stay in curr city : curr during day i then point += stayScore[i][curr];
        // where i = day and curr = curr city 
        // 2: move to other city if they move form curr to dest point += travel[curr][dest]

        // n = 2 cities k = 1 day 0 indexed so 0 and 1 stay score [[2,3]] on each day 2 = day one 3 on day two max = 3 
        // travler score = [0,2][1,0] so day one curr and dest = 0 , so we will get the points from the only one of the 2 like 2 or 1 as they are max ex day zero 
        // curr is 0 then then the dest could be only 0 , 2 the max is 2 so we take that so the max is 2 or curr = 1 then the dest could be 0 or 1 then the max is 1 or 0 so here max is 1 the max among them is 2 and the max among stay is 3 so return 
        // on day zero we stay where we are we get[0][0or1] then we take either 0 or 1 where it is max 


        // So we have to option so it is dp Ig at each point we can either move forward of stay there so ig its that only bro

        // but there are mulitple cities so we can also skip to any cities right from 0 to 3 rd so we can also skip the city lmao wth
        this.n = n ; 
        this.k = k ; 
        int ans = 0 ; 
        dp = new int[n][k];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i] , -1);
        }
        for(int i = 0 ; i < n; i++){
            ans = Math.max(ans , f(i , 0 ,  stayScore , travelScore));
        }
        return ans;
    }
}