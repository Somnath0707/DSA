class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // we have landStartTime the earliest time the ith land ride can be boarded 
        // land duration how long the ith land ride last 


        // water StartTime the earliest time the water ride can be boarded 
        // water duration how long the jth ride will last 

        // a tourist must experiece exactly one rie from each category in either order 
        // If a ride is started at time t , it finishes at time t + duration 
        // immediaterly ater fininshing one ride the tourist may board the other if already open or wait until it opens

        // earliest time at which a tourst can finish both rides 
        int n = landStartTime.length; 
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE ; 

        for(int i = 0 ; i < n ; i++){
            int total = landStartTime[i] + landDuration[i]; 

            for(int j = 0 ; j < m ; j++){
                if(waterStartTime[j] <= total){
                    int waterTotal  = total + waterDuration[j] ;
                    ans = Math.min(ans , waterTotal);
                }
                else {
                    int waterTotal = waterStartTime[j] + waterDuration[j]; 
                    ans = Math.min(ans , waterTotal);
                }
            }
        }
        int secondAns = Integer.MAX_VALUE;
        for(int i = 0 ; i < m ; i++){
            int total = waterStartTime[i] + waterDuration[i]; 

            for(int j = 0 ; j < n ; j++){
                if(landStartTime[j] <= total){
                    int landTotal  = total + landDuration[j]; 
                    secondAns = Math.min(secondAns , landTotal);
                }
                else{
                    int landTotal = landStartTime[j] + landDuration[j] ; 
                    secondAns = Math.min(secondAns , landTotal);
                }
            }
        }

    return Math.min(secondAns , ans); 
    }
}

// 99 + 54 = 153 +85 = 238 
// 153 + 20 = 178

// 54 + 20 = 74 