class Solution {
    public int shipWithinDays(int[] weights, int days) {


        int sum =0 ; 
        int heaviest = 0; 
        for(int n : weights ){
            sum += n;
            heaviest = Math.max(heaviest , n );
        }

        int left = heaviest; 
        int right = sum ; 
        int ans = 0; 


        while(left <= right ) {
            int mid = left + (right - left) / 2 ;

            if(getDays(weights , mid) <= days){
                ans = mid ; 
                right = mid -1; 
            }else {
                left = mid + 1; 
            }
        
        }
        return ans ; 
        // get the total count of weight as the right 
        //max weight from the ship as the left as we will need to carray atleast that 
        // tkae the mid 

        // a function to check if we can take mid weight 
        // so go through all the weight and reduce that much from the mid 
        // if the answer goes to negative increase the days 
        // return the days for the that mid 
        // else do the regular binary search 
    }


    public int getDays(int nums[] , int capacity){
        int currLoad = 0; 
        int usedDays = 1; 

        for(int n: nums){
            if(currLoad+n > capacity){
                usedDays++;
                currLoad = 0; 
            }
            currLoad+=n;
        }
        return usedDays;
    }
}