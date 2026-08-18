class Solution {
    public int largestInteger(int[] nums, int k) {
        int ans = -1 ; 
        int n = nums.length ;
        int temp = -1 ; 
       

        
        Map<Integer,Integer> map = new HashMap<>(); 
        int j = 0 ; 

        for(int i = 0 ; i < n-k+1 ; i++){
            Set<Integer>set = new HashSet<>();
            j = i ;  
            while(j-i < k){
                if(set.contains(nums[j])){
                    j++; 
                }else{
                    map.put(nums[j] , map.getOrDefault(nums[j] , 0)+1);
                    set.add(nums[j]);
                    j++;
                }
            }
        }
         for(int num : nums){
            if(map.get(num) <= 1)
            temp = Math.max(temp ,num); 
        }
        if(k == 1 || k == n) return temp; 
        int first = nums[0]; 
        int last = nums[n-1]; 
        if(map.get(first) > 1 && map.get(last) > 1) return -1; 
        else if(map.get(first)>1) return last; 
        else if(map.get(last) > 1) return first; 
        else
        return Math.max(first, last); 
    }
}