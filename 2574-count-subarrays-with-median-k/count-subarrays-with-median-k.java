class Solution {
    public int countSubarrays(int[] nums, int k) {
        // 3 2 1 4 5 noraml
        // -1 -1 -1 0 1 just 1 and 0
        // -1 -2 -3 -3 -2 prefix sum 
        // -2 -1 0 1 1 suffix sum
        int n = nums.length ; 

        int indx = -1 ; 

        // Find the k 
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == k){
                indx = i ; 
                break ;
            }
        } 

        Map<Integer,Integer> map = new HashMap<>();
        //  Keep the k in the map 
        map.put(0 , 1);
        // Calculate the prefix Sum
        int sum = 0 ; 


        // go to the right side 
        // Go from indx + 1 as we have already processed the inx
        for(int i = indx + 1 ; i < n ; i++ ){
            if(nums[i] > k) sum++;
            else if(nums[i] < k) sum -- ; 

            map.put(sum , map.getOrDefault(sum , 0) + 1 );
        }

        /// Balanced should be +1 or 0 

        int ans = 0 ; 
        sum  = 0 ; 
        for(int i = indx ; i >= 0 ; i--){
            if(nums[i] > k) sum++;
            else if(nums[i] < k ) sum -- ; 

            // Match the balance 0 or 1 
            // here if we got sum -2 then there should already be +2 in the right side only then could we add else we add 0 
            ans += map.getOrDefault(-sum , 0);

            // Same here but we can also allow one buffer 
            ans += map.getOrDefault(1-sum , 0 );

        }

        return ans; 

    }
}