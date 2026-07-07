class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        // try to put where the smallest 
        int n = startTime.length; 


        int gap[] = new int[n+1]; 

        gap[0] = startTime[0]; 

        for(int i = 1 ; i < n ; i++){
            gap[i] = startTime[i] - endTime[i-1];
        }

        gap[n] = eventTime - endTime[n-1];

        int prefix[] = new int[n+1]; 

        prefix[0] = gap[0]; 
        for(int i = 1 ; i < n+1 ; i++){
            prefix[i] = Math.max(prefix[i-1] , gap[i]);
        }
        int suffix[] = new int[n+1];
        suffix[n] = gap[n];
        for(int i = gap.length-2; i>= 0 ; i--){
            suffix[i] = Math.max(suffix[i+1] , gap[i]);
        }

        int max = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int duration = endTime[i]-startTime[i];
            int temp = 0 ; 
            if(i == 0){
                if(suffix[i+2] >= duration){
                    temp = duration + gap[i+1] + gap[0];
                }
                else
                temp = gap[0] + gap[1];
            }
            else if(i == n-1){
                if(prefix[i-1] >= duration){
                    temp = duration + gap[i] + gap[i+1]; 
                }
                else
                    temp = gap[i] + gap[i+1];
            }
            else if(prefix[i-1] >= duration || suffix[i+2] >= duration ){
                temp = gap[i] + duration + gap[i+1];
            }
            else temp = gap[i] + gap[i+1]; 

            max = Math.max(max , temp);
        }



        return max; 
    }
}