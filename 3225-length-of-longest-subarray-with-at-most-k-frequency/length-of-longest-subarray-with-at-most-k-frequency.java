class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(); 
        int n = nums.length ; 
        int max = 0; 
        int start = 0 ; 
        // if(k == 1) return 1; 
        int j = 0; 
        for(int i = 0 ; i < n ; i ++){
            int val = nums[i]; 
            map.put(val , map.getOrDefault(val , 0)+1); 
            while(map.get(val) > k){
                System.out.println(map.get(j));
                map.put(nums[j] , map.get(nums[j])-1);
                if(map.get(nums[j]) == 0) map.remove(nums[j]); 
                j++; 
            } 

            max = Math.max(i-j+1 , max); 

        }
        return max; 
    }
}