class Solution {
    public int longestWPI(int[] hours) {
        // 9 9 6 0 6 6 9

        // int left = ; 
        // int right =hours.length-1; 
        // int ans = -1; 
        // while(left < right){
        //     int mid = left + (right -left) / 2; 

        //     if(check(mid , hours)){
        //         ans = mid ; 
        //         left = mid+1; 
        //     }
        //     else 
        // }
        int n = hours.length; 
        int ans = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int countGreat = 0;
            int countLow = 0 ;
            for(int j = i ; j < n ; j++){
                if(hours[j] > 8) countGreat++; 
                else countLow++; 

                // System.out.print(ln)
                if(countGreat > countLow){
                    ans = Math.max(ans , j-i+1); 
                }
            }
        }

        return ans; 

    }
}

// is this condtion monotonic ? [9,9,6,0,6,6,9]
// means if there is well perfoming days of 3 is it sure that there are well performing days of 2 and 1 too in this it is there 

// 9 2 2 9 9 2 2 2
// so the condition is not monotonic so no binary search on window size 





