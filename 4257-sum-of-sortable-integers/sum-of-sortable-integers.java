class Solution {
    public boolean checkCond(int k , int [] nums){
        int n = nums.length ;
        int left = 0 ; 
        int right = 0; 
        int prevMax = Integer.MIN_VALUE;
        int prevMin = Integer.MAX_VALUE;
        
        while( right < n ){

            int max =nums[left];
            int min = nums[left];
            int dropped = 0 ; 
            for(int i = left+1 ; i < left + k ; i++){
                if (nums[i] < nums[(i - 1) % n]){
                    dropped++; 
                    if (dropped > 1) {
                        return false; 
                    }
                }

                max = Math.max(max , nums[i]);
                min = Math.min(min , nums[i]);
            }
            if (dropped == 1 && nums[left + k - 1] > nums[left]) {
                return false;
            }
            if(min < prevMax){
                return false; 
            }else{
                prevMin = min;
                prevMax = max;
                left += k;
                right += k;
            }
            // Check for the drop in the size k of the array 

        }
        return true; 
    }
    public int sortableIntegers(int[] nums) {
        // the the k size window check 
        int n = nums.length;

        // 7 8 10 1 2 3
        int sum = 0 ; 


        for(int i = 1 ; i <= n ; i++){
            if(n % i == 0 ){
                if(checkCond(i , nums)){
                    System.out.println(" sum till now : " + sum);
                    sum += i ;
                    System.out.println(sum);
                }
            }
            // Divisor of n 
            else{
                continue;
            }
        }
        return sum ; 
    }
}

// 12,18,14 -> 12 