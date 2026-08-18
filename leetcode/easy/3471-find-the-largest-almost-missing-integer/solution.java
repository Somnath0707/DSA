class Solution {
    public int largestInteger(int[] nums, int k) {
        int ans = -1 ; 
        int n = nums.length ;

        Map<Integer,Integer> map = new HashMap<>(); 
        
        for(int i = 0 ; i < n-k+1 ; i++){
            Set<Integer> taken = new HashSet<>(); 
            for(int j = i ; j < i+k ; j++){
                if(taken.contains(nums[j])) continue; 
                int val = nums[j]; 
                map.put(val , map.getOrDefault(val , 0)+1);
                taken.add(val); 
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getValue(); 
            int key = entry.getKey(); 
            if(val == 1){
                ans = Math.max(ans , key); 
            }
        }
        return ans; 
    }
}