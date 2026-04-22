class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        
        int max = Integer.MIN_VALUE;
        int maxLeft = 1; 
        int maxRight = 1;
        int i = 0 ; 
        int j = n -1 ; 

        while(i < n && j >= 0 ){
            maxLeft *= nums[i++];
            maxRight *= nums[j--];

            max = Math.max(max , Math.max(maxLeft , maxRight));
            if(maxLeft == 0) maxLeft = 1 ; 
            if(maxRight == 0) maxRight = 1 ;
        }

        return max;
    }
}