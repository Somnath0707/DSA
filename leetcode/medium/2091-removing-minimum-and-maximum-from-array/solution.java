class Solution {
    public int minimumDeletions(int[] nums) {
        int minIndx = -1; 
        int maxIndx = -1; 
        int min = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE; 
        int ind = 0 ; 
        for(int curr : nums){
            if(curr < min){
                min = curr; 
                minIndx = ind; 
            }
            if(curr > max){
                max = curr; 
                maxIndx = ind; 
            }
            ind++; 
        }
        int n = nums.length; 
        int first = Math.min(minIndx+1 , n-minIndx);
        int second = Math.min(maxIndx +1 , n- maxIndx);
        int firstMin =  first + second; 

        int maxRemove = Math.max(minIndx , maxIndx)+1; 

        int minRemove = Math.max(n-minIndx , n-maxIndx); 

        return Math.min(minRemove , Math.min(firstMin , maxRemove)); 


    }
}