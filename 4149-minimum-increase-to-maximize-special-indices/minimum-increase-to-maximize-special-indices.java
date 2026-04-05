class Solution {
    public long minIncrease(int[] nums) {
        int n = nums.length ; 

        long cost[] = new long[n];

        for(int i = 1 ; i < n-1 ;i++){
            int target = Math.max(nums[i-1] , nums[i+1])  + 1 ; 

            cost[i] = Math.max(0L , (long) target - nums[i]);
        }


        if(n % 2 == 1 ) {
            long total = 0 ; 
            for(int i = 1 ; i < n-1 ; i+= 2 ){
                total += cost[i] ; 
            }
            return total ; 
        }

        long prefix[] = new long[n];

        for(int i = 1 ; i < n-1 ; i++){
            prefix[i] = (i>= 2 ? prefix[i-2] : 0 ) + cost[i];
        }

        long suffix[] = new long[n]; 
        for(int i = n - 2; i >=  1 ; i--){
            suffix[i] = ( i+2 < n ? suffix[i+2] : 0 ) + cost[i];
        }


        long minOperations = Math.min(prefix[n-3] , suffix[2]);


        for(int i = 2 ; i < n-2 ; i+= 2 ) {
            minOperations = Math.min(minOperations , prefix[i-1 ] + suffix[i+2]);
        }
        return minOperations;
    }
    
}