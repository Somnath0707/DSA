class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int max = 0 ; 
        for(int num :  lights){
            max = Math.max(num , max); 
        }
        int ans = 0 ; 
        int n = arrivalTime.length ; 
        for(int i = 0 ; i < n ; i++){
            int val = arrivalTime[i]; 
            int r = val % period; 

            if(r < max ){
                continue; 
            }else{
                ans = Math.max(ans , period - r);
            }
        }
        return ans; 
    }
}