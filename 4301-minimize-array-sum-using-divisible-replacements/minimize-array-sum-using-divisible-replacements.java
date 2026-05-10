class Solution {
    public long minArraySum(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }


        for(int i = 0 ; i < nums.length ; i++){
            int n = nums[i];


            for(int j = 1 ; j * j <= n ; j++ ){
                if(n % j == 0 ){
                    if(set.contains(j)){
                        nums[i] = Math.min(nums[i] , j);
                    }

                    int other = n / j ; 
                    if(set.contains(other)){
                        
                        nums[i] = Math.min(other , nums[i]); 
                    }    
                }    
            }
        }

        long ans = 0 ;
        for(int n : nums){
            ans+= n;
        }
        return ans;
    }
}