class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        // here we goon subarrays again 
        int n = nums.length ; 
        int diff[] = new int[n]; 
        for(int i = 0; i < n ;i++){
            diff[i] = target[i] - nums[i]; 
        }

        long ans = 0 ; 
        int prev = 0 ; 
        for(int i = 0 ; i < n ; i++){
            int curr = diff[i]; 

            if(prev > 0 && curr > 0  ){
                if(curr > prev)
                ans += curr - prev ; 
                // System.out.println(curr + " " + prev);

            }
        //                  -3 < -2
            else if(prev < 0 && curr < 0 ){
                if(curr < prev)
                ans += Math.abs(curr - prev);
            }

            else {
                ans += Math.abs(curr ); 
            }

            prev = curr; 
        }

        return ans ; 
        
    }
}