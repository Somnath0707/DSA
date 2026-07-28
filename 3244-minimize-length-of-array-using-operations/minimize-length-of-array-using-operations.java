class Solution {
    public int minimumArrayLength(int[] nums) {
        Arrays.sort(nums); 
        int min = nums[0]; 
        int minCount = 0 ;
        int n = nums.length;  
        for(int i = 0 ; i< n ; i++){
            if(nums[i] == min) minCount++; 
            if(nums[i] > min) break; 
        }

        if(minCount ==1 ) return 1; 

        for(int i = 0 ; i < n ; i++){
            if(nums[i] % min != 0) return 1; 
        }
        if(minCount % 2 == 0) return minCount / 2; 
        return minCount /2 + 1; 
    }
}