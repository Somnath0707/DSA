class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;

        int n = landStartTime.length ; 

        // lnad first 
        int endLand = Integer.MAX_VALUE;

        // we got the minimum duration or the fastest to the end 
        for(int i = 0 ; i < n ; i ++){
            endLand = Math.min(endLand , landStartTime[i] + landDuration[i]);
        }

        int m = waterDuration.length;
        // we check that with the the water 
        for(int i = 0 ; i < m ; i++){
            ans = Math.min(ans , waterDuration[i] + Math.max(endLand , waterStartTime[i]));
        }




        // water first 
        int waterEnd = Integer.MAX_VALUE;

        for(int i = 0 ; i < m ; i++){
            waterEnd = Math.min(waterEnd , waterStartTime[i] + waterDuration[i]);
        }

        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans , landDuration[i] + Math.max(waterEnd , landStartTime[i]));
        }

        return ans ;
    }
}

// make a 2d array [start][end] for the both land and water 
// keep the pointer on each land and water and do binary search what ??
// may be take the first of the both see the ansewr like take the first and see if the water has started if not then take the second and check if that is started
// Immediately after finishing one ride the tourist may board the other (if it is already open) or wait until it open
// so the take the lowest of both wont that work ?? or do we have to use the binary search on both 

// [[2,4] [4,1]]. water [[6,3]]

// so do we do binary search on both land and water like binary search on the land then binary sarch on the water for the same land we select on the land
// make in 2d array
//  we have to sort by start time and also if same we take in asceindy 
//  then take binary search on the land and take that do binary search on the water 
//  