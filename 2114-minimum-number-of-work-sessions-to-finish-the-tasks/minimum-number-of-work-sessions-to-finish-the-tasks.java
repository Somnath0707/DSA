class Solution {
    int target ; 
    Integer dp[][][] ; 
    public int f(int i , int totalTime , int mask , int nums[]){
        if (mask == (1 << nums.length) - 1) {
            return 0; 
        }
        

        if( i == nums.length){
            if(totalTime == 0) return 1000000009;
            return 1 + f(0 , 0 , mask , nums) ;
        } 
        if(dp[i][totalTime][mask] != null ) return dp[i][totalTime][mask]; 


        if ((mask & (1 << i)) != 0) {
            return f(i + 1, totalTime, mask, nums);
        }
        int take = 1000000009 ; 

        if(totalTime + nums[i] <= target){
            int takeFirst = f(i+1, totalTime + nums[i] , mask | (1 << i), nums);  
            int skipDirect = f(i+1 , totalTime  , mask , nums); 
            int newSession = 1 + f(0 , nums[i] , mask | (1 << i) , nums); 

            take = Math.min(takeFirst , Math.min(skipDirect , newSession));
        }
        else{
            int skip = f(i+1 , totalTime , mask , nums);
            int newSession = 1 + f(0 , nums[i] , mask | (1 << i), nums); 

            take = Math.min(skip , newSession); 

        }

        return dp[i][totalTime][mask] = take; 
    }
    public int minSessions(int[] nums, int sessionTime) {
        // there are n task assigned to me 
        // the task times are represented as an integer array 
        // where the i th task take tasks]i] hrs to finsih
        //  a wokrk sessoin is when you work for at most session time consecutive hour and then take a break 

        // you should finish the given task in way that satifsi the following condition : 
        // 1. If you start a task in work session you must complete in the same work session only 
        // 2. You can start new task immediately after finsiing prev task 

        // at each point if we are in the range we have few chooice 
        // one is if the prev taks + curr task we are on <= session time we can either take that task (if not already taken )or move to next task or start new session al together 
        // if we decided to move forward or start or take the current session wee will just do seesion time + curr not + 1 in answer but if we decided to start new session then we can do 1 + 


        // what are the other stuff we can do 

        // for each time we should do ig for loop that go from 0 to n to take the number as we might skip the few in the begining but we should have some thig that tells use we have already taken this index is already taken previously so dont take this index now 
        // at end if all the index are taken we return 0 that is we have go the answer or return 1e9 to tell them that this is not the answer 
        int n = nums.length; 
        dp = new Integer[n + 1][sessionTime + 1][1 << n];
        target = sessionTime; 

        return 1 +  f(0 , 0 , 0 , nums );
    }
}